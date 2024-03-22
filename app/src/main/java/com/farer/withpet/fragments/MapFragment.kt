package com.farer.withpet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.farer.withpet.R
import com.farer.withpet.activities.MainActivity
import com.farer.withpet.databinding.FragmentMapBinding
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.camera.CameraUpdate
import com.kakao.vectormap.camera.CameraUpdateFactory
import com.kakao.vectormap.label.LabelLayer
import com.kakao.vectormap.label.LabelOptions
import java.lang.Exception

class MapFragment : Fragment() {

    private val binding by lazy { FragmentMapBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mapView.start(lifeCycleCallback, mapReadyCallback)
    }

        private val lifeCycleCallback: MapLifeCycleCallback = object : MapLifeCycleCallback(){
            override fun onMapDestroy() {
                Toast.makeText(context, "맵이 종료됩니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onMapError(p0: Exception?) {
                Toast.makeText(context, "$p0", Toast.LENGTH_SHORT).show()
            }
        }

        private val mapReadyCallback: KakaoMapReadyCallback = object : KakaoMapReadyCallback(){

            override fun onMapReady(kakaoMap: KakaoMap) {

//                val latitude: Double= (activity as MainActivity).myLocation?.latitude ?: 37.5666
//                val longitude: Double= (activity as MainActivity).myLocation?.longitude ?: 126.9782
//                val myPos: LatLng= LatLng.from(latitude, longitude)
//
//                val cameraUpdate: CameraUpdate= CameraUpdateFactory.newCenterPosition(myPos, 16)
//                KakaoMap.moveCamera(cameraUpdate)
//
//                val labelOptions: LabelOptions = LabelOptions.from(myPos).setStyles(R.drawable.ic_mypin)
//                val labelLayer: LabelLayer = KakaoMap.labelManager!!.layer!!
//                labelLayer.addLabel(labelOptions)
            }

            override fun getPosition(): LatLng {
                return LatLng.from(37.406960, 127.115587)
            }

            override fun getZoomLevel(): Int {
                return 15
            }

            override fun isVisible(): Boolean {
                return true
            }
        }


}