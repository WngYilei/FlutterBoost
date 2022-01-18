package com.xl.boosttestandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xl.boosttestandroid.ui.theme.BoostTestAndroidTheme
import com.idlefish.flutterboost.FlutterBoost

import com.idlefish.flutterboost.FlutterBoostRouteOptions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoostTestAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Button(
                            onClick = {
                                val argument = HashMap<String, Any>()
                                argument["data"] = "test" + System.currentTimeMillis()

                                val options = FlutterBoostRouteOptions.Builder()
                                    .pageName("mainPage")
                                    .arguments(argument)
                                    .requestCode(1111)
                                    .build()
                                FlutterBoost.instance().open(options)

                            }, modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Text(text = "跳转第一个页面")
                        }

                        Button(
                            onClick = {

                                val options = FlutterBoostRouteOptions.Builder()
                                    .pageName("simplePage")
                                    .arguments(HashMap())
                                    .requestCode(1111)
                                    .build()
                                FlutterBoost.instance().open(options)

                            }, modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Text(text = "跳转第一个页面")
                        }
                    }
                }
            }
        }
    }
}

