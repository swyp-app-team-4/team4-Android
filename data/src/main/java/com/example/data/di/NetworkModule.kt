package com.example.data.di

import android.content.Context
import com.example.data.network.auth.AuthApi
import com.example.data.network.navermap.NaverMapApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.io.File
import javax.inject.Qualifier
import javax.inject.Singleton

// Qualifiers to distinguish between different Retrofit and OkHttp instances
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NoAuthRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NaverRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NaverOkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://api.boombim.p-e.kr/"
    private const val NAVER_URL = "https://openapi.naver.com/"

    @Provides
    @Singleton
    @DefaultOkHttpClient
    fun provideDefaultOkHttpClient(
        @ApplicationContext context: Context
    ): OkHttpClient.Builder {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .cache(Cache(File(context.cacheDir, "http_cache"), 50L * 1024L * 1024L))
    }


    private fun makeRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    }


    @Provides
    @Singleton
    @NoAuthRetrofit
    fun provideNoAuthRetrofit(
        @DefaultOkHttpClient okHttpClientBuilder: OkHttpClient.Builder
    ): Retrofit = makeRetrofit(okHttpClientBuilder.build(), BASE_URL)


    @Provides
    @Singleton
    @NaverRetrofit
    fun provideNaverRetrofit(
        @DefaultOkHttpClient okHttpClientBuilder: OkHttpClient.Builder
    ): Retrofit = makeRetrofit(okHttpClientBuilder.build(), NAVER_URL)

    @Provides
    @Singleton
    fun provideAuthApi(
        @NoAuthRetrofit retrofit: Retrofit
    ): AuthApi = retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideNaverSearchApi(
        @NaverRetrofit retrofit: Retrofit
    ): NaverMapApi = retrofit.create(NaverMapApi::class.java)
}
