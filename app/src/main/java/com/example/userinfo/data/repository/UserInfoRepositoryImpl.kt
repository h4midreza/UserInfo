package com.example.userinfo.data.repository

import com.example.userinfo.data.remote.api.UserInfoApi
import com.example.userinfo.data.remote.toUserInfo
import com.example.userinfo.domain.model.UserInfo
import com.example.userinfo.domain.repository.UserInfoRepository
import com.example.utils.Constants.DEFAULT_PAGE_INDEX
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val api: UserInfoApi
) : UserInfoRepository {
    override suspend fun getUserInfoList(): List<UserInfo> {
        return api.getUsers(page = DEFAULT_PAGE_INDEX).results.map { it.toUserInfo() }
    }
}

