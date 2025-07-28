package com.example.userinfo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UserInfoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class UserInfoDatabase : RoomDatabase() {
    abstract fun userInfoDao(): UserInfoDao
}