package com.example.swift

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.navercorp.nid.NaverIdLoginSDK
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BoomBimApp : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "")

        NaverIdLoginSDK.initialize(
            this,
            "",        // 네이버 개발자 센터에서 발급
            "",    // 네이버 개발자 센터에서 발급
            "붐빔"          // 사용자에게 보여질 앱 이름
        )

    }
}