package com.example.th1myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.th1myfirstapp.ui.theme.TH1MyFirstAppTheme // Đảm bảo đúng tên package của bạn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TH1MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingScreen()
                }
            }
        }
    }
}

@Composable
fun GreetingScreen() {
    // Sử dụng mutableStateOf để quản lý trạng thái của Text
    var message by remember { mutableStateOf("Hello") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween, // Đẩy Title và Button về 2 phía
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Phần tiêu đề "My First App"
        Text(
            text = "My First App",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 48.dp) // Khoảng cách từ trên xuống
        )

        // Phần nội dung thay đổi
        Text(
            text = message,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 0.dp) // Có thể thêm padding nếu cần
        )

        // Nút "Say Hi!"
        Button(
            onClick = {
                // Khi nút được bấm, cập nhật giá trị của message
                message = "I'm\nNguyễn Minh Nhật" // Sử dụng \n để
                // xuống dòng
            },
            modifier = Modifier.padding(bottom = 48.dp) // Khoảng cách từ dưới lên
        ) {
            Text(text = "Say Hi!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    TH1MyFirstAppTheme {
        GreetingScreen()
    }
}
