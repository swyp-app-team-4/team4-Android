package com.example.domain.repository

import com.example.domain.model.ActionResult
import com.example.domain.model.SocialLoginSignUpResult

interface AuthRepository {
    suspend fun socialLogin(
        provider: String,
        accessToken: String,
        refreshToken: String,
        expiresIn: Int,
        idToken: String
    ): ActionResult<SocialLoginSignUpResult>
}