package com.example.freegames.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.freegames.ui.screens.DrawbackScreen
import com.example.freegames.ui.screens.ErrorScreen
import com.example.freegames.ui.screens.MainScreen
import com.example.freegames.ui.screens.SuccessResultScreen
import com.example.freegames.ui.viewmodel.MainViewModel
import com.example.freegames.ui.viewmodel.Resource

@Composable
fun NavigationAppHost(
    navController: NavHostController,
    viewModel: MainViewModel,
) {

    val pcGameState = viewModel.pcGameState.collectAsState().value
    val browseGamesState = viewModel.browseGamesState.collectAsState().value

    if (pcGameState is Resource.Error && browseGamesState is Resource.Error){
        navController.navigate(NavDestination.ErrorScreen.route)
    }
    if (pcGameState is Resource.Error || browseGamesState is Resource.Error){
        navController.navigate(NavDestination.DrawbackScreen.route)
    }
    if (pcGameState is Resource.Success && browseGamesState is Resource.Success){
        navController.navigate(NavDestination.SuccessResultScreen.route)
    }


    NavHost(
        navController = navController,
        startDestination = NavDestination.MainScreen.route,
    ){

        composable(route = NavDestination.MainScreen.route) {
            MainScreen(
                onGetGamesClick = {
                    viewModel.getPcShooters()
                    viewModel.getBrowserRpg()
                }
            )
        }
        composable(route = NavDestination.SuccessResultScreen.route) {
            SuccessResultScreen(
                pcGameState = pcGameState,
                browserGameState = browseGamesState
            )
        }
        composable(route = NavDestination.ErrorScreen.route) {
             ErrorScreen(
                 tryAgainClick = {
                     viewModel.getPcShooters()
                     viewModel.getPcShooters()
                 }
             )
        }
        composable(route = NavDestination.DrawbackScreen.route) {
            DrawbackScreen(
                pcGameState = pcGameState,
                browserGameState = browseGamesState
            )
        }
    }
}



sealed class NavDestination(val route: String) {
    object MainScreen: NavDestination("main_screen")
    object ErrorScreen: NavDestination("error_screen")
    object SuccessResultScreen : NavDestination("success_screen")
    object DrawbackScreen : NavDestination("drawback_screen")
}