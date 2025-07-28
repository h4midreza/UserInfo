package com.example.userinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userinfo.domain.usecase.GetUserInfoUseCase
import com.example.userinfo.presentation.uistate.UserInfoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UserInfoUiState>(UserInfoUiState.Loading)
    val uiState: StateFlow<UserInfoUiState> = _uiState

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            try {
                val users = getUserInfoUseCase()
                _uiState.value = UserInfoUiState.Success(users)
            } catch (e: Exception) {
                _uiState.value = UserInfoUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

