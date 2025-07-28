package com.example.userinfo.di

import com.example.userinfo.data.local.UserInfoDao
import com.example.userinfo.data.local.UserInfoDatabase
import com.example.userinfo.data.remote.UserInfoRemoteMediator
import com.example.userinfo.data.repository.UserInfoRepositoryImpl
import com.example.userinfo.domain.repository.UserInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideUserInfoApi(dao: UserInfoDao, mediator: UserInfoRemoteMediator): UserInfoRepository {
        return UserInfoRepositoryImpl(dao, mediator)
    }
}