package com.example.seoultour

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlaceActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_place)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 인텐트에 저장된 데이터 가져오기
        val title = intent.getStringExtra("TITLE")
        val address = intent.getStringExtra("ADDR")
        val desc = intent.getStringExtra("DESC")
        val photo = intent.getIntExtra("PHOTO", 0)
        // 인텐트에 저장된 Place 객체 가져오기
        val place = intent.getParcelableExtra("PLACE", Place::class.java)
        findViewById<TextView>(R.id.placename).text = place?.title
        findViewById<TextView>(R.id.address).text = place?.address
        findViewById<TextView>(R.id.desc).text = desc
        findViewById<ImageView>(R.id.placeimg).setImageResource(photo)


    }
}








