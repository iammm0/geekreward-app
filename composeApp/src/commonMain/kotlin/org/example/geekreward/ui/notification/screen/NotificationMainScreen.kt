import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationMainScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("消息") }) }
    ) {
        // 内容区域
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("欢迎来到消息界面！", fontSize = 24.sp)
        }
    }
}
