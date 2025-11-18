package com.example.tourapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OptionActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_option)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        radioGroup = findViewById(R.id.radioGroupAccommodation)
        checkBox = findViewById(R.id.checkboxBreakfast)

        // MainActivity가 보내준 데이터 가져오기
        val city = intent.getStringExtra("CITY")

        findViewById<Button>(R.id.completeButton).setOnClickListener {
            val hotel = getSelection()
            val act = ActivityOption("크루즈투어", 55000, 4)

            val returnIntent = Intent()
            returnIntent.putExtra("HOTEL", hotel)
            returnIntent.putExtra("ACTIVITY", act)

            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }

    private fun getSelection(): HotelOption {
        val selectedId = radioGroup.checkedRadioButtonId
        val hasBreakfast = checkBox.isChecked // 수정됨

        return when (selectedId) {
            R.id.radioHotel -> HotelOption("베스트웨스턴호텔", 150000, hasBreakfast)
            R.id.radioGuesthouse -> HotelOption("해피게스트하우스", 50000, hasBreakfast)
            else -> HotelOption("미선택", 0, false)
        }
    }
}
