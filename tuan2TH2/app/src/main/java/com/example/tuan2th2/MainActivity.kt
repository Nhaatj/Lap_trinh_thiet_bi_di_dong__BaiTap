package com.example.tuan2th2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController // Import này quan trọng

import com.example.tuan2th2.ui.theme.Tuan2TH2Theme

// Bắt đầu từ đây: Chỉnh sửa MainActivity.kt
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tuan2TH2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController() // Tạo NavController

                    NavHost(navController = navController, startDestination = "onboarding_screen") {
                        composable("onboarding_screen") {
                            OnboardingScreen(navController = navController) // Truyền navController
                        }
                        composable("ui_components_list") {
                            UiComponentsListScreen(navController = navController) // Truyền navController
                        }
                        composable("text_detail") {
                            TextDetailScreen(navController = navController)
                        }
                        composable("images_screen") {
                            ImagesScreen(navController = navController)
                        }
                        composable("textfield_screen") {
                            TextFieldScreen(navController = navController)
                        }
                        composable("passwordfield_screen") {
                            PasswordFieldScreen(navController = navController)
                        }
                        composable("column_layout") {
                            ColumnLayoutScreen(navController = navController)
                        }
                        composable("row_layout") {
                            RowLayoutScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OnboardingScreen(navController: NavController) { // Thêm navController vào tham số
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Section: Tên và số điện thoại
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Nguyễn Minh Nhật",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "2251120034",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Middle Section: Icon, Tiêu đề và Mô tả
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Jetpack Compose Logo",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Jetpack Compose",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Bottom Section: Nút "I'm ready"
        Button(
            onClick = { navController.navigate("ui_components_list") }, // Điều hướng khi nút bấm
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .padding(bottom = 48.dp)
                .height(56.dp)
        ) {
            Text(
                text = "I'm ready",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

// Preview cho OnboardingScreen
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun OnboardingScreenPreview() {
    Tuan2TH2Theme {
        // Trong preview, bạn cần một NavController giả
        OnboardingScreen(navController = rememberNavController())
    }
}