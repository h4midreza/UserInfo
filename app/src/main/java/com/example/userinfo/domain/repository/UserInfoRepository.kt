package com.example.userinfo.domain.repository

import com.example.userinfo.domain.model.UserInfo

interface UserInfoRepository {
    suspend fun getUserInfoList(): List<UserInfo>
}
