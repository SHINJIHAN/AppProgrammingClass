package com.example.arrayapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 이미지들의 배열을 생성
    val cartoons = listOf(R.drawable.img1, R.drawable.img2,
                            R.drawable.img3, R.drawable.img4)

    val names = listOf("man1, man2, man3, man4")
    val result = Array(4){false}

    var index = 0 // 배열의 이미지 원소를 가리키는 색인값

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            // 에디트 텍스트에 입력한 값을 읽어오기
            val name = findViewById<EditText>(R.id.cartoon).text.toString()

            // msg를 var로 선언하여 변경 가능하게 함
            var msg = ""

//            // 배열에 입력한 값이 있는지 확인
//            msg = if (names.contains(name)) {
//                "$name 캐릭터명이 존재합니다."
//            } else {
//                "$name 캐릭터명이 없습니다."
//            }

            // 입력값이 배열에 있는지 확인
            if (names.contains(name)) {
                msg = "정답입니다."
            } else {
                msg = "틀렸습니다."
            }

            // 토스트 출력
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

            // 다음 이미지를 선택해서 이미지뷰에 표시하는 코드
            val imageView = findViewById<ImageView>(R.id.cartoon)
            if (index < cartoons.size - 1) index++ else index = 0
            imageView.setImageResource(cartoons[index])

            // 에디트 텍스트에 입력된 값을 삭제하기
            findViewById<EditText>(R.id.name).text.clear()
        }
    }
}
