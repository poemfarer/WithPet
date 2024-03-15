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

        val ma = activity as MainActivity
        var ca3 = ma.searchPlaceResponse!!.data.get(0).category3

        if (ca3.equals("식당")) {

        } else if (ca3.equals("카페")) {

        } else if (ca3.equals("동물병원")){

        } else if (ca3.equals("동물약국")){

        } else if (ca3.equals("여행지")){

        }

    }


}