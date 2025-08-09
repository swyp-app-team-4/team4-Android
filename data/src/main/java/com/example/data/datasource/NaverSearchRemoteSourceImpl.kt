package com.example.data.datasource

import com.example.data.network.navermap.NaverMapApi
import com.example.data.network.safeFlow
import com.example.domain.datasource.NaverSearchRemoteSource
import com.example.domain.model.ApiResult
import com.example.domain.model.NaverSearchResponse
import com.example.domain.model.Place
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NaverSearchRemoteSourceImpl @Inject constructor(
    private val naverMapApi: NaverMapApi
) : NaverSearchRemoteSource {

    override suspend fun getSearchList(query: String): Flow<ApiResult<NaverSearchResponse>> {
        return safeFlow { naverMapApi.getMapSearch(query) }
    }

}