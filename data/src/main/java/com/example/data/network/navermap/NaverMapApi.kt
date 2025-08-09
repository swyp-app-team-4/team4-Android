package com.example.data.network.navermap

import com.example.domain.model.NaverSearchResponse
import com.example.domain.model.Place
import com.example.domain.model.PlaceListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverMapApi {
    // 네이버 지도 장소 검색 api
    @GET("v1/search/local.json")
    suspend fun getMapSearch(
        @Query("query") query: String,      // 검색어
        @Query("display") display: Int = 5,    // 검색 결과 출력 건수
        @Header("X-Naver-Client-Id") clientId: String = "WFRKsx3t7gMMESxx7Vth",    // 검색 클라이언트 아이디
        @Header("X-Naver-Client-Secret") clientSecret: String = "T3SCqoevVy",     // 검색 클라이언트 시크릿
    ): Response<NaverSearchResponse>
}