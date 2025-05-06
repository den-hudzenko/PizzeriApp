package com.example.pizzeriapp.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pizzerapp.Navigation.MainNavGraph
import com.example.pizzerapp.Navigation.ScreensEnum
import com.example.pizzeriapp.R



@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainSetup(navController: NavHostController = rememberNavController()){


    Scaffold (
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            var currentRoute = navBackStackEntry?.destination?.route

            NavigationBar(modifier = Modifier.height(85.dp), containerColor = Color(0xFFA000AC)){
                bottomNavItems.forEachIndexed { index, navigationItem ->
                    val selected = navigationItem.route == currentRoute

                    NavigationBarItem(selected = navigationItem.route == currentRoute,
                        onClick = {
                            currentRoute = navigationItem.route
                            navController.navigate(navigationItem.route)
                        },
                        label = {
                            Text(
                                text = navigationItem.name,
                                fontFamily = FontFamily(Font(R.font.black)),
                                fontSize = 12.sp,
                                color = Color.White
                            )
                        },
                        icon = {
                            val iconColor = if (selected) Color.Black else Color.White
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.name,
                                modifier = Modifier.fillMaxSize(0.3F),
                                tint = iconColor
                            )
                        }
                    )
                }
            }
        }
    ){
            paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            MainNavGraph(navController = navController)
        }
    }

}

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem(
        name = "Menu",
        route = ScreensEnum.MENU.name,
        icon = Icons.Rounded.Home,
    ),
    BottomNavItem(
        name = "Shopping Card",
        route = ScreensEnum.SHOPPING_CART_SCREEN.name,
        icon = Icons.Rounded.AddCircle,
    ),
    BottomNavItem(
        name = "Order",
        route = ScreensEnum.ORDER.name,
        icon = Icons.Rounded.DateRange,
    ),
)

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewBottom(){
    MainSetup()
}