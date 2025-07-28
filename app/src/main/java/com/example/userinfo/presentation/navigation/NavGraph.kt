package com.example.userinfo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.userinfo.presentation.UserInfoScreen
import com.example.utils.Constants.USER_LIST


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = USER_LIST) {
        composable(USER_LIST) {
            UserInfoScreen()
        }
    }
}