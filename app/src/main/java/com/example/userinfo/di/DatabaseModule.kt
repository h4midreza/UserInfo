package com.example.userinfo.di

import android.content.Context
import androidx.room.Room
import com.example.userinfo.data.local.UserInfoDao
import com.example.userinfo.data.local.UserInfoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(appContext: Context): UserInfoDatabase {
        return Room.databaseBuilder(
            appContext,
            UserInfoDatabase::class.java,
            "user_info_db"
        ).build()
    }

    @Provides
    fun provideUserInfoDao(database: UserInfoDatabase): UserInfoDao {
        return database.userInfoDao()
    }
}