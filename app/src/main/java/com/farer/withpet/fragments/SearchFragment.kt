package com.farer.withpet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.farer.withpet.RecyclerAdapter
import com.farer.withpet.activities.MainActivity
import com.farer.withpet.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var i = 0
        val ma = activity as MainActivity
        val spr= ma.searchPlaceResponse!!.data
        var ispermit = spr.get(i).ispermit
        var ca3 = spr.get(i).category3

        //var data1: MutableList<String> = mutableListOf()
        var data1: MutableList<String> = mutableListOf()
        var data: MutableList<List<String>> = mutableListOf(data1)

        for (i in 0 until spr.size){

        }

        if (ispermit.equals("동반가능")){
            if (ca3.equals("식당")) {
                //data1. add(ma.searchPlaceResponse!!.data.get(0).placeName)
                data1.add(spr.get(i).placeName)
                data1.add(spr.get(i).area)
                data1.add(spr.get(i).latitude)
                data1.add(spr.get(i).longitude)

            } else if (ca3.equals("카페")) {

            } else if (ca3.equals("동물병원")) {

            } else if (ca3.equals("동물약국")) {

            } else if (ca3.equals("여행지")) {

            }
        }


        binding.restaurant.setOnClickListener {
            Toast.makeText(context, "$data1", Toast.LENGTH_SHORT).show()
        }
    }


}