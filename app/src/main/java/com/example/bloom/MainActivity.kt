package com.example.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bloom.ui.theme.BloomTheme

@Suppress("UNCHECKED_CAST")
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repository = InMemoryPlantServices()
                return HomeViewModel(
                    plantRepository = repository
                ) as T
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomTheme {
                val navController = rememberNavController()
                NavHost(navController, "welcome") {
                    composable("welcome") {
                        WelcomeScreen(navController)
                    }
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("home") {
                       HomeScreen(homeViewModel = homeViewModel)
                    }
                }
            }
        }
    }
}

