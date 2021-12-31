package com.example.healthhutplugin_example

import android.os.Bundle
import android.util.Log
import androidx.annotation.NonNull
import com.example.healthhutplugin.HealthhutpluginPlugin
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import android.content.Intent
import com.sinosoft.healthhut.HealthHutActivity
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import org.json.JSONObject


class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor,
            "healthhutplugin"
        ).setMethodCallHandler { call, result ->
            Log.d("7777", call.method);
            if (call.method == "jumpHealthHutModular") {
                // 参数
                val arguments = call.arguments<String>()
                val jsonObject = JSONObject(arguments);
                 val intent = Intent();
                Log.d("333",jsonObject.getString("userId"))
                intent.setClass(this,HealthHutActivity::class.java);
                intent.putExtra("userId",jsonObject.getString("userId"));
                startActivity(intent);
            } else {
                result.notImplemented()
            }
        }
    }
}
