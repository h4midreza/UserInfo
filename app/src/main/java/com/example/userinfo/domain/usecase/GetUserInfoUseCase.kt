package com.example.userinfo.domain.usecase

import androidx.paging.PagingData
import com.example.userinfo.domain.model.UserInfo
import com.example.userinfo.domain.repository.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val repository: UserInfoRepository
) {
    operator fun invoke(query: String): Flow<PagingData<UserInfo>> {
        return repository.getUserInfoList(query)
    }
}