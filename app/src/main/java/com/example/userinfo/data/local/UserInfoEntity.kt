package com.example.userinfo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.userinfo.domain.model.UserInfo

@Entity(tableName = "user_info_table")
data class UserInfoEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val image: String
) {
    fun toUserInfo(): UserInfo = UserInfo(id, name, status, image)

    companion object {
        fun fromUserInfo(userInfo: UserInfo): UserInfoEntity =
            UserInfoEntity(
                id = userInfo.id,
                name = userInfo.name,
                status = userInfo.status,
                image = userInfo.image
            )
    }
}
