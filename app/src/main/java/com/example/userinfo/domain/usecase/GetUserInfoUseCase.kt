package com.example.userinfo.domain.usecase

import com.example.userinfo.domain.model.UserInfo
import com.example.userinfo.domain.repository.UserInfoRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val repository: UserInfoRepository
) {
    suspend operator fun invoke(): List<UserInfo> {
        return repository.getUserInfoList()
    }
}