package com.example.userinfo.di

import com.example.userinfo.data.remote.api.UserInfoApi
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
    fun provideUserInfoApi(api: UserInfoApi): UserInfoRepository {
        return UserInfoRepositoryImpl(api)
    }
}