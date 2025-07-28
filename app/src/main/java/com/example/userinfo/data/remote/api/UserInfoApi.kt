package com.example.userinfo.data.remote.api

import com.example.userinfo.data.remote.dto.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UserInfoApi {
    @GET("character")
    suspend fun getUsers(
        @Query("page") page: Int
    ): UserResponseDto
}
