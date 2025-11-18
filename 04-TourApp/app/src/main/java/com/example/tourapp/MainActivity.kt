package com.example.tourapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 결과를 받기 위한 런처 변수 선언
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 결과 수신 준비
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val hotel = data?.getSerializableExtra("HOTEL") as? HotelOption
                val act = data?.getSerializableExtra("ACTIVITY") as? ActivityOption

                if (hotel != null && act != null) {
                    findViewById<TextView>(R.id.resultTextView).text =
                        "숙소: ${hotel.name} (${hotel.price}원, 조식: ${if (hotel.hasBreakfast) "포함" else "불포함"})\n" +
                                "활동: ${act.name} (${act.price}원, 평점 ${act.hours})"
                } else {
                    findViewById<TextView>(R.id.resultTextView).text = "결과 없음"
                }
            }
        }

        // 버튼 클릭 시 OptionActivity 실행
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, OptionActivity::class.java)
            intent.putExtra("CITY", "Seoul")
            resultLauncher.launch(intent)
        }
    }
}
