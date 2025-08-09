package com.example.domain.datasource

import android.app.DownloadManager.Query
import com.example.domain.model.ApiResult
import com.example.domain.model.NaverSearchResponse
import com.example.domain.model.Place
import kotlinx.coroutines.flow.Flow

interface NaverSearchRemoteSource {

    suspend fun getSearchList(query: String): Flow<ApiResult<NaverSearchResponse>>
}