package com.example.swift.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.FetchNoticeUseCase
import com.example.domain.usecase.GetNoticeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NaverSearchViewModel @Inject constructor(
    getNoticeListUseCase: GetNoticeListUseCase,
    fetchNoticeUseCase: FetchNoticeUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            fetchNoticeUseCase("고덕")
        }

    }

    // 공지화면 공지 목록
    val noticeList = getNoticeListUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            emptyList()
        )
}