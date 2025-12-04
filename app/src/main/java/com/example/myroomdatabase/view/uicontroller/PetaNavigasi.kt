package com.example.myroomdatabase.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myroomdatabase.view.DetailSiswaScreen
import com.example.myroomdatabase.view.EditSiswaScreen
import com.example.myroomdatabase.view.EntrySiswaScreen
import com.example.myroomdatabase.view.HomeScreen
import com.example.myroomdatabase.view.route.DestinasiDetailSiswa
import com.example.myroomdatabase.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.myroomdatabase.view.route.DestinasiEditSiswa
import com.example.myroomdatabase.view.route.DestinasiHome
import com.example.myroomdatabase.view.route.DestinasiEntry

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(),
             modifier: Modifier = Modifier ) {
    HostNavigasi(navController = navController,modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinasiHome.route,
        modifier = Modifier) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/$it")
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            // --- PERBAIKAN DI SINI ---
            // Gunakan referensi lengkap ke properti const val.
            arguments = listOf(navArgument(DestinasiDetailSiswa.itemIdArg) { type = NavType.IntType })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { id: Int -> navController.navigate("${DestinasiEditSiswa.route}/$id") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg) { type = NavType.IntType })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }

}