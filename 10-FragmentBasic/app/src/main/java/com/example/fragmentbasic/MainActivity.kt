package com.example.fragmentbasic

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragmentbasic.databinding.ActivityMainBinding

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
        // 프래그먼트 변경하기
        //findViewById<ImageButton>(R.id.imageButton).setOnClickListener {
        binding.imageButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_view, LionFragment())
                .commit()
        }
        findViewById<ImageButton>(R.id.imageButton2).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_view, ElephantFragment())
                .commit()
        }
    }
}