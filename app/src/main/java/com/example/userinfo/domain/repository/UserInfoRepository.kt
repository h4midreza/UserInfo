package com.example.userinfo.domain.repository

import androidx.paging.PagingData
import com.example.userinfo.domain.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface UserInfoRepository {
    fun getUserInfoList(query: String): Flow<PagingData<UserInfo>>
}
