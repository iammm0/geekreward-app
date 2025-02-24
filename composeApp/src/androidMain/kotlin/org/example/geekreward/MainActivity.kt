package org.example.geekreward

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.example.geekreward.main.App
import org.example.geekreward.ui.theme.GeekRewardTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // 使用 GeekRewardTheme 包裹整个应用内容
            GeekRewardTheme {
                // 这是应用的根界面，您可以将它替换为其他组件，比如 MainScreen
                Surface {
                    SystemUiController()
                    val navController = rememberNavController()

                    MainScreen(
                        navController = navController
                    ) // 显示主界面
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}