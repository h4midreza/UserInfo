package com.example.userinfo.data.remote

import com.example.userinfo.data.remote.api.UserInfoApi

import androidx.paging.ExperimentalPagingApi
import androidx.paging.RemoteMediator
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.room.withTransaction
import com.example.userinfo.data.local.UserInfoDatabase
import com.example.userinfo.data.local.UserInfoEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class UserInfoRemoteMediator(
    private val api: UserInfoApi,
    private val database: UserInfoDatabase
) : RemoteMediator<Int, UserInfoEntity>() {

    private val dao = database.userInfoDao()

    private var currentPage = 1

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UserInfoEntity>
    ): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    currentPage + 1
                }
            }

            val response = api.getUsers(page)
            val users = response.results.map { dto ->
                UserInfoEntity.fromUserInfo(
                    dto.toUserInfo()
                )
            }

            val endOfPaginationReached = response.info.next == null

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    dao.clearAll()
                }
                dao.insertAll(users)
            }

            currentPage = page

            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (exception: IOException) {
            MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            MediatorResult.Error(exception)
        }
    }
}