package com.example.domain.usecase

import com.example.domain.repository.NaverPlaceListRepository
import jakarta.inject.Inject

class GetNoticeListUseCase @Inject constructor(
    private val repository: NaverPlaceListRepository
) {
    operator fun invoke() = repository.getSearchList()
}