package com.example.mystorage

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mystorage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // SharedPrefrences 실습
        binding.btnSharedPrefs.setOnClickListener {
            val intent = Intent(this, SharedPrefsActivity::class.java)
            startActivity(intent)
        }
        // FileStorage 실습
        binding.btnFileStorage.setOnClickListener {
            startActivity(Intent(this, FileStorageActivity::class.java))
        }
        // SQLite DB 실습
        binding.btnSqlite.setOnClickListener {
            startActivity(Intent(this, SqliteActivity::class.java))
        }
    }
}










