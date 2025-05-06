package com.example.pizzerapp.Navigation

import SignUpScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pizzerapp.Screens.SignInScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {

    navigation(
        route = Graphs.AUTHENTICATION,
        startDestination = ScreensEnum.SIGN_UP.name
    ) {
        composable(ScreensEnum.SIGN_UP.name){
            SignUpScreen { navController.navigate(ScreensEnum.SIGN_IN.name) }
        }
        composable(ScreensEnum.SIGN_IN.name){
            SignInScreen(navController)
        }
    }
}