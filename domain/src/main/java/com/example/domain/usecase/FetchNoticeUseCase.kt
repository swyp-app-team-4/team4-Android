package com.example.domain.usecase

import com.example.domain.repository.NaverPlaceListRepository
import jakarta.inject.Inject

class FetchNoticeUseCase @Inject constructor(
    private val repository: NaverPlaceListRepository
) {
    suspend operator fun invoke(query: String) {
        repository.getNotice(
            query =query
        )
    }
}