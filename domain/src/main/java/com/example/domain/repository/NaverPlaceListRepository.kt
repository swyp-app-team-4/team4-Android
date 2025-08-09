package com.example.domain.repository

import com.example.domain.model.ApiResult
import com.example.domain.model.NaverSearchResponse
import com.example.domain.model.Place
import com.example.domain.model.PlaceListDTO
import kotlinx.coroutines.flow.Flow

interface NaverPlaceListRepository {
    fun getSearchList(): Flow<List<Place>>

    suspend fun getNotice(query: String)
}