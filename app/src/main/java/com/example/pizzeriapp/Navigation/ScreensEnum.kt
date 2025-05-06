package com.example.pizzerapp.Navigation

enum class ScreensEnum {
    MENU,
    ORDER,
    SHOPPING_CART_SCREEN,
    SIGN_IN,
    SIGN_UP
}

object Graphs{
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "authentication_graph"
    const val MAIN = "main_graph"
}