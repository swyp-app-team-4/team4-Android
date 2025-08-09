package com.example.data.di

import com.example.data.repository.AuthRepositoryImpl
import com.example.data.repository.NaverPlaceListRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.NaverPlaceListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindNaverSearchRepository(
        impl: NaverPlaceListRepositoryImpl
    ): NaverPlaceListRepository
}