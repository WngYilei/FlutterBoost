package com.xl.boosttestandroid

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.idlefish.flutterboost.containers.FlutterBoostActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class FlutterPage : FlutterBoostActivity() {
    private val CHANNEL = "samples.flutter.io/battery"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "--------------------------------------------")
    }


    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        MethodChannel(flutterEngine.dartExecutor, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "getBatteryLevel") {
                Log.e("TAG", "、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、: ")
                Toast.makeText(this@FlutterPage, "给你个大B逗", Toast.LENGTH_LONG).show()
                result.success(111111)
            } else {
                result.notImplemented()
            }
        }
    }


}