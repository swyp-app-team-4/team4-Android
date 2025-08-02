package com.example.swift

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BoomBimApp : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "")

    }
}