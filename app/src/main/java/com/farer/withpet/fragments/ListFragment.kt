package com.farer.withpet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.farer.withpet.activities.MainActivity
import com.farer.withpet.databinding.FragmentListBinding
import com.farer.withpet.RecyclerAdapter

class ListFragment : Fragment() {

    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity:MainActivity = activity as MainActivity
        mainActivity.searchPlaceResponse ?: return

        binding.recyclerView.adapter= RecyclerAdapter(requireContext(), mainActivity.searchPlaceResponse!!.data)
    }
}