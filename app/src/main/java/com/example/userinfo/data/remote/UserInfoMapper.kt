package com.example.userinfo.data.remote

import com.example.userinfo.domain.model.UserInfo
import com.example.userinfo.data.remote.dto.UserDto

fun UserDto.toUserInfo(): UserInfo {
    return UserInfo(
        id = id,
        name = name,
        image = image,
        status = status
    )
}

