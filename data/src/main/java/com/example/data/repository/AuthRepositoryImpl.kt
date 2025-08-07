package com.example.data.repository

import com.example.data.datastore.AppManageDataStore
import com.example.data.extension.covertApiResultToActionResultIfSuccess
import com.example.domain.datasource.AuthRemoteDataSource
import com.example.domain.model.ActionResult
import com.example.domain.model.ApiResult
import com.example.domain.model.SocialLoginSignUpResult
import com.example.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthRemoteDataSource,
    private val appManageDataStore: AppManageDataStore
) : AuthRepository {

    override suspend fun socialLogin(
        provider: String,
        accessToken: String,
        refreshToken: String,
        expiresIn: Int,
        idToken: String
    ): ActionResult<SocialLoginSignUpResult> {
        val result = authDataSource.socialLogin(
            provider = provider,
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiresIn = expiresIn,
            idToken = idToken
        )

        if (result is ApiResult.Success) {
            val body = result.data
            val access = body.accessToken
            val refresh = body.refreshToken

            access.let { appManageDataStore.saveAccessToken(it) }
            refresh.let { appManageDataStore.saveRefreshToken(it) }
        }
        return result.covertApiResultToActionResultIfSuccess()
    }

}