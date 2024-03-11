package com.farer.withpet.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.farer.withpet.databinding.ActivityPlaceBinding

class PlaceActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPlaceBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}