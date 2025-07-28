package com.example.userinfo.data.remote.dto

data class UserResponseDto(
    val info: InfoDto,
    val results: List<UserDto>
)

data class InfoDto(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class UserDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String
)
