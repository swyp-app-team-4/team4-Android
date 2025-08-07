package com.example.data.network.auth.request

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest (
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Int,
    val idToken: String? = null,
)