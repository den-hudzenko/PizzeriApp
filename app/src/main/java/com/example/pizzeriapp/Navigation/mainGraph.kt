package com.example.pizzerapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pizzerapp.Screens.MenuScreen
import com.example.pizzerapp.Screens.OrderScreen
import com.example.pizzerapp.Screens.ShoppingCartScreen

@Composable
fun MainNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graphs.MAIN,
        startDestination = ScreensEnum.MENU.name
    ) {
        composable(ScreensEnum.MENU.name){
            MenuScreen()
        }
        composable(ScreensEnum.SHOPPING_CART_SCREEN.name){
            ShoppingCartScreen(navController)
        }
        composable(ScreensEnum.ORDER.name){
            OrderScreen()
        }
    }
}