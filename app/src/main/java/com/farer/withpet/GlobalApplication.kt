package com.farer.withpet

import android.app.Application
import com.kakao.vectormap.KakaoMapSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoMapSdk.init(this, "6e68c207200bd83c4b974c0ac9abe88f")
    }
}