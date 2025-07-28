package com.example.userinfo.presentation.uistate

import com.example.userinfo.domain.model.UserInfo

sealed class UserInfoUiState {
    object Loading : UserInfoUiState()
    data class Success(val users: List<UserInfo>) : UserInfoUiState()
    data class Error(val message: String) : UserInfoUiState()
}
