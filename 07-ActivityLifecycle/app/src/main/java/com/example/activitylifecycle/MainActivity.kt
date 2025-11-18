package com.example.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var logTextView: TextView
    private lateinit var btnSecondActivity: Button
    private val logBuilder = StringBuilder()
    private val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // UI 초기화
        logTextView = findViewById(R.id.logTextView)
        btnSecondActivity = findViewById(R.id.btnSecondActivity)
        logLifecycle("onCreate() - 액티비티가 생성됨")
        btnSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        // savedInstanceState 확인
        if (savedInstanceState != null) {
            // 종료 전에 저장해둔 상태값이 있다는 것
            // 자동으로 onRestoreInstanceState() 실행
            logLifecycle("onCreate() - 이전 상태 복원됨!!")
        }
    }
    override fun onStart() {
        super.onStart()
        logLifecycle("onStart() - 액티비티가 사용자에게 보이기 시작")
    }

    override fun onResume() {
        super.onResume()
        logLifecycle("onResume() - 액티비티가 포그라운드에서 실행 중")
    }

    override fun onPause() {
        super.onPause()
        logLifecycle("onPause() - 액티비티가 일부 보이지만 포커스 잃음")
    }

    override fun onStop() {
        super.onStop()
        logLifecycle("onStop() - 액티비티가 더 이상 보이지 않음")
    }

    override fun onRestart() {
        super.onRestart()
        logLifecycle("onRestart() - 중지된 액티비티가 다시 시작됨")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycle("onDestroy() - 액티비티가 종료됨")
    }
    // 액티비티 소멸(onDestroy())될 때 상태값을 저장하는 함수
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logLifecycle("onSaveInstanceState() - 상태 저장!!!")
        outState.putString("LOGDATA", logBuilder.toString())
    }
    // 액티비티 생성(onCreate())될 때 저장된 상태값을 가져오는 함수
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logLifecycle("onRestoreInstanceState() - 상태 복원!!!")
        val savedLog = savedInstanceState.getString("LOGDATA")
        if (savedLog?.isNotEmpty() ?: false) {
            logBuilder.clear()
            logBuilder.append(savedLog)
        }
    }

    private fun logLifecycle(message: String) {
        val timestamp = dateFormat.format(Date())
        val logMessage = "[$timestamp] $message\n"

        // 로그캣에 출력
        Log.d(TAG, message)

        // UI에 표시
        logBuilder.append(logMessage)
        runOnUiThread {
            logTextView?.text = logBuilder.toString()
        }
    }
}