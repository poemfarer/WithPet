package com.farer.withpet.activities

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.farer.withpet.data.PlaceData
import com.farer.withpet.fragments.ListFragment
import com.farer.withpet.fragments.MapFragment
import com.farer.withpet.fragments.SearchFragment
import com.farer.withpet.R
import com.farer.withpet.data.Place
import com.farer.withpet.databinding.ActivityMainBinding
import com.farer.withpet.network.RetrofitHelper
import com.farer.withpet.network.RetrofitService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var myLocation: Location?= null

    val locationProviderClient: FusedLocationProviderClient by lazy { LocationServices.getFusedLocationProviderClient(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        searchPlace()

        supportFragmentManager.beginTransaction().add(R.id.container_fragment, ListFragment()).commit()

        binding.bnv.setOnItemSelectedListener {

            when(it.itemId){
                R.id.menu_bnv_list -> supportFragmentManager.beginTransaction().replace(R.id.container_fragment, ListFragment()).commit()
                R.id.menu_bnv_map -> supportFragmentManager.beginTransaction().replace(R.id.container_fragment, MapFragment()).commit()
                R.id.menu_bnv_search -> supportFragmentManager.beginTransaction().replace(R.id.container_fragment, SearchFragment()).commit()
                //MyAccount Fragment 추가
            }

            true
        }

        val permissionsState: Int= checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
        if (permissionsState==PackageManager.PERMISSION_DENIED){
            permissionResultLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            requestMyLocation()
        }

        binding.refresh.setOnClickListener {
            requestMyLocation()
        }

    }

    private val locationCallback= object : LocationCallback(){
        override fun onLocationResult(p0: LocationResult) {
            super.onLocationResult(p0)

            myLocation= p0.lastLocation
            locationProviderClient.removeLocationUpdates(this)
        }
    }

    private fun requestMyLocation(){

        val request: LocationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 3000).build()

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ){ return
        }
        locationProviderClient.requestLocationUpdates(request, locationCallback, Looper.getMainLooper())
    }

    val permissionResultLauncher: ActivityResultLauncher<String> = registerForActivityResult(ActivityResultContracts.RequestPermission()){
        if (it) requestMyLocation()
        else Toast.makeText(this, "위치 정보를 제공하지 않아, 검색 기능 사용이 제한됩니다.", Toast.LENGTH_SHORT).show()
    }
    private fun searchPlace(){
        val retrofit= RetrofitHelper.getRetrofitInstance("https://api.odcloud.kr")
        val retrofitService= retrofit.create(RetrofitService::class.java)
        val call= retrofitService.searchPlace("시설명", "도로명주소")
        call.enqueue(object : Callback<PlaceData>{
            override fun onResponse(call: Call<PlaceData>, response: Response<PlaceData>) {
                searchPlaceResponse= response.body()

                val data: List<Place>?= searchPlaceResponse?.data
                AlertDialog.Builder(this@MainActivity).setMessage("${data?.get(0)?.placeName}").create().show()

            }

            override fun onFailure(call: Call<PlaceData>, t: Throwable) {
                Toast.makeText(this@MainActivity, "서버 오류가 있습니다.", Toast.LENGTH_SHORT).show()
            }

        })

        //데이터가 제대로 불러왔는지 테스트
//        val call= retrofitService.searchPlaceToString("시설명", "도로명주소")
//        call.enqueue(object : Callback<String>{
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                val s= response.body()
//                AlertDialog.Builder(this@MainActivity).setMessage(s).create().show()
//            }
//
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "error: ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//
//        })
    }

    var searchPlaceResponse: PlaceData? = null
}