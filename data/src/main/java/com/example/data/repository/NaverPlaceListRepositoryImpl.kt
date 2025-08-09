package com.example.data.repository

import com.example.domain.datasource.NaverSearchRemoteSource
import com.example.domain.model.ApiResult
import com.example.domain.model.Place
import com.example.domain.model.PlaceListDTO
import com.example.domain.repository.NaverPlaceListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class NaverPlaceListRepositoryImpl @Inject constructor(
    private val naverSearchRemoteSource: NaverSearchRemoteSource
) : NaverPlaceListRepository {
    // 장소 목록을 저장하는 StateFlow
    private val _placeList = MutableStateFlow(emptyList<Place>())

    private val placeList
        get() = _placeList.asStateFlow()

    override fun getSearchList(): Flow<List<Place>> = placeList

    override suspend fun getNotice(query: String) {
       naverSearchRemoteSource.getSearchList(query).first().let { result ->
           if(result is ApiResult.Success) {
               _placeList.update {
                   result.data.items
               }
           }
       }
    }
}