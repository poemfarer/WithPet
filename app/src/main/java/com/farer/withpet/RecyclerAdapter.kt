package com.farer.withpet

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.farer.withpet.data.Place
import com.farer.withpet.databinding.RecyclerItemListFragmentBinding

class RecyclerAdapter(val context: Context, val placeList: List<Place>) : Adapter<RecyclerAdapter.VH>() {

    inner class VH(val binding: RecyclerItemListFragmentBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater= LayoutInflater.from(context)
        val binding= RecyclerItemListFragmentBinding.inflate(layoutInflater, parent, false)
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val place = placeList[position]

        holder.binding.tvPlaceName.text= place.placeName
        holder.binding.tvRoadAddress.text= if (place.roadAddress=="") place.address else place.roadAddress
    }
}