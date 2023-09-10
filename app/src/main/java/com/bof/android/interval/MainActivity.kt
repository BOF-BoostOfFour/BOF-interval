package com.bof.android.interval

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bof.android.interval.presentation.IntervalMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 앱의 네비게이션 설정. 함수 내부에서 전체 router의 NavController 정의.
            AppNavigator()
        }
    }
}

/**
 * 앱 내부 네비게이션 설정.
 * 사용법:
 * 1. 선언: composable("태그 이름") { 화면 컴포즈 함수 }
 * 2. 불러오기: navController.navigate("태그 이름")
 */
@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { IntervalMainScreen(navController = navController) }
        composable("detail") { /* todo anotherScreen */ }
    }
}