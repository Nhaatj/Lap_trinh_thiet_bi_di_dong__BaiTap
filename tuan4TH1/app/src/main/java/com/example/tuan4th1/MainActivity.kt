package com.example.tuan4th1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuan4th1.ui.screens.DetailScreen
import com.example.tuan4th1.ui.screens.LazyColumnScreen
import com.example.tuan4th1.ui.screens.NavigationScreen
import com.example.tuan4th1.ui.theme.Tuan4TH1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tuan4TH1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "navigation_screen") {
        composable("navigation_screen") {
            NavigationScreen(navController = navController)
        }
        composable("lazy_column_screen") {
            LazyColumnScreen(navController = navController)
        }
        // Truyền index hoặc id của item để hiển thị nội dung chi tiết
        composable("detail_screen/{itemIndex}") { backStackEntry ->
            val itemIndex = backStackEntry.arguments?.getString("itemIndex")
            DetailScreen(navController = navController, itemIndex = itemIndex)
        }
    }
}