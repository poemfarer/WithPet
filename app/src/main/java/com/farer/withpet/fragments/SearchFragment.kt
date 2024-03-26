package com.farer.withpet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.farer.withpet.RecyclerAdapter
import com.farer.withpet.activities.MainActivity
import com.farer.withpet.data.Place
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

        val ma: MainActivity = activity as MainActivity
        ma.searchPlaceResponse ?: return

        val spr = ma.searchPlaceResponse!!.data

        var i = 0
        var ispermit = spr.get(i).ispermit
        var ca3 = spr.get(i).category3

//        var data: MutableList<Place> = mutableListOf()
        var cafe: MutableList<Place> = mutableListOf() //카페
        var hospital: MutableList<Place> = mutableListOf() //병원
        var pharmacy: MutableList<Place> = mutableListOf() //약국
        var salon: MutableList<Place> = mutableListOf() //미용실
        var market: MutableList<Place> = mutableListOf() //반려동물용품
        var consignment: MutableList<Place> = mutableListOf() //위탁관리
        var travel: MutableList<Place> = mutableListOf() //여행지
        var pension: MutableList<Place> = mutableListOf() //펜션
        var restaurant: MutableList<Place> = mutableListOf() //식당

        for (i in 0 until spr.size) {
            if (spr.get(i).category3.equals("카페")) { cafe.add(spr[i]) }
            else if (spr.get(i).category3.equals("동물병원")) { hospital.add(spr[i]) }
            else if (spr.get(i).category3.equals("동물약국")) { pharmacy.add(spr[i]) }
            else if (spr.get(i).category3.equals("미용")) { salon.add(spr[i]) }
            else if (spr.get(i).category3.equals("반려동물용품")) { market.add(spr[i]) }
            else if (spr.get(i).category3.equals("위탁관리")) { consignment.add(spr[i]) }
            else if (spr.get(i).category3.equals("여행지")) { travel.add(spr[i]) }
            else if (spr.get(i).category3.equals("펜션")) { pension.add(spr[i]) }
            else if (spr.get(i).category3.equals("식당")) { restaurant.add(spr[i]) }
            binding.recyclerView.adapter = RecyclerAdapter(requireContext(), cafe)
        }

        binding.cafe.setOnClickListener { binding.recyclerView.adapter= RecyclerAdapter(requireContext(), cafe) }
        binding.hospital.setOnClickListener { binding.recyclerView.adapter= RecyclerAdapter(requireContext(), hospital) }
        binding.pharmacy.setOnClickListener { binding.recyclerView.adapter= RecyclerAdapter(requireContext(), pharmacy) }
        binding.salon.setOnClickListener { binding.recyclerView.adapter= RecyclerAdapter(requireContext(), salon) }
        binding.market.setOnClickListener { binding.recyclerView.adapter= RecyclerAdapter(requireContext(), market) }
        binding.consignment.setOnClickListener { binding.recyclerView.adapter= RecyclerAdapter(requireContext(), consignment) }
        binding.pension.setOnClickListener { binding.recyclerView.adapter= RecyclerAdapter(requireContext(), pension) }
        binding.travel.setOnClickListener { binding.recyclerView.adapter= RecyclerAdapter(requireContext(), travel) }
        binding.restaurant.setOnClickListener { binding.recyclerView.adapter= RecyclerAdapter(requireContext(), restaurant) }
    }


}