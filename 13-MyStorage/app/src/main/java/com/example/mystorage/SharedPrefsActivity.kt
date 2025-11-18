package com.example.mystorage

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mystorage.databinding.ActivitySharedPrefsBinding

class SharedPrefsActivity : AppCompatActivity() {
    private val PREFS_NAME = "settings"  // 기호상수 정의
    private lateinit var binding: ActivitySharedPrefsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySharedPrefsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // SharedPrefrences 데이터 저장하기
        binding.btnSave.setOnClickListener {
            val text = binding.etInput.text.toString()
            // SharedPrefrences 인스턴스 생성하기
            val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            // 데이터 저장하기
            prefs.edit().putString("NAME", text).apply()   // 비동기 처리
            prefs.edit().putFloat("SCORE", 4.3f).commit()  // 동기 처리
            binding.etInput.text.clear()
        }
        // SharedPrefrences 데이터 가져오기
        binding.btnLoad.setOnClickListener {
            val prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
            val text = prefs.getString("NAME", "None")
            val score = prefs.getFloat("SCORE", 0.0f)
            binding.tvResult.text = "저장된 값: $text / $score"
        }
    }
}











