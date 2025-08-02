package com.example.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WhereRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NoAuthRetrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

}