package com.example.userinfo.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dagger.Provides

@Dao
interface UserInfoDao {

    @Query("SELECT * FROM user_info_table ORDER BY name ASC")
    fun getAllUsers(): PagingSource<Int, UserInfoEntity>

    @Query("SELECT * FROM user_info_table WHERE name LIKE '%' || :query || '%' ORDER BY id ASC")
    fun searchUsers(query: String): PagingSource<Int, UserInfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserInfoEntity>)

    @Query("DELETE FROM user_info_table")
    suspend fun clearAll()
}