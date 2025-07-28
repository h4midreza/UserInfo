package com.example.userinfo.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.userinfo.data.local.UserInfoDao
import com.example.userinfo.data.remote.UserInfoRemoteMediator
import com.example.userinfo.domain.model.UserInfo
import com.example.userinfo.domain.repository.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val dao: UserInfoDao,
    private val remoteMediator: UserInfoRemoteMediator
) : UserInfoRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getUserInfoList(query: String): Flow<PagingData<UserInfo>> {
        val pagingSourceFactory = { dao.searchUsers("%${query}%") }

        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = remoteMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData ->
            pagingData.map { entity ->
                entity.toUserInfo()
            }
        }
    }
}
