package com.bof.android.interval.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * 인터벌 메인 화면의 전체 화면.
 */
@Composable
fun IntervalMainScreen(navController: NavController) {
    val intervalViewModel: IntervalViewModel = viewModel()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        // 최상단 앱바
        AppBar(title = "", onBackClicked = { navController.popBackStack() })
        // 투명 디바이더 역할
        Spacer(modifier = Modifier.height(20.dp))
        // todo 타이머 위치.
        Timer()
        // todo 타이머랑 버튼이 같이 만들어질 것 같으나, 테스트 용으로.
        Buttons(intervalViewModel)
    }
}

/**
 * 최상단 앱바.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onBackClicked: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onBackClicked() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
            }
        }
    )
}

/**
 * 실질적인 Timer가 들어갈 예정. 로직은 대신 Timer 모듈에서 가져온다.
 */
@Composable
fun Timer() {
    Surface {
        Text(text = "이 곳에 타이머가 들어갑니다.")
    }
}

/**
 * 테스트용 버튼 묶음.(나중에 필요 없을 예정)
 */
@Composable
fun Buttons(
    viewModel: IntervalViewModel
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = {
            Toast.makeText(context, "message", Toast.LENGTH_LONG).show()
            // todo for debug.
            viewModel.createStopWatch(10000L)
            viewModel.playStopWatch { Log.d("WATCH", "${viewModel.getCurTime()}") }
        }) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "play")
        }
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "play")
        }
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "play")
        }
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "play")
        }
    }
}

// ---------------------- preview line -------------------------
//

@Composable
@Preview
fun IntervalMainScreenPreview() {
    IntervalMainScreen(rememberNavController())
}

@Composable
@Preview
fun TimerPreview() {
    Timer()
}