package com.example.userinfo.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.userinfo.presentation.components.UserItem
import com.example.userinfo.presentation.uistate.UserInfoUiState
import com.example.userinfo.presentation.viewmodel.UserInfoViewModel

@Composable
fun UserInfoScreen(viewModel: UserInfoViewModel = hiltViewModel()) {
    val uiState: UserInfoUiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UserInfoUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UserInfoUiState.Success -> {
            val users = (uiState as UserInfoUiState.Success).users
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(users.size) { user ->
                    UserItem(user = users[user])
                }
            }
        }

        is UserInfoUiState.Error -> {
            val errorMessage = (uiState as UserInfoUiState.Error).message
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = errorMessage, color = Color.Red)
            }
        }
    }
}
