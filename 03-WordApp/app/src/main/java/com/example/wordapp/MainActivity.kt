package com.example.wordapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wordapp.Word

class MainActivity : AppCompatActivity() {
    // 클래스 멤버변수
    val wordNote = mapOf<String, Word>("apple" to Word("apple","사과"),
        "banana" to Word("banana", "바나나"),
    )
    private val wordMap = mapOf( "apple" to "사과", "banana" to "바나나",
        "orange" to "오렌지", "grape" to "포도", "strawberry" to "딸기",
        "book" to "책", "pen" to "펜", "desk" to "책상", "chair" to "의자",
        "computer" to "컴퓨터", "house" to "집", "car" to "자동차",
        "train" to "기차", "plane" to "비행기", "sun" to "태양",
        "moon" to "달", "star" to "별", "cloud" to "구름", "river" to "강",
        "mountain" to "산" )
    var eword = ""  // 영어단어 저장 멤버변수
    lateinit var resultView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // 액티비티와 디자인뷰가 결합. 화면 보여지는 것
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        resultView = findViewById<TextView>(R.id.result)
        displayWord()
        findViewById<Button>(R.id.button).setOnClickListener {
            checkAnswer()   // 버튼 클릭하면 정답확인하러 함수 호출
        }
    }
    // 영어단어 하나를 문제로 출제하는 함수
    fun displayWord() {
        // wordMap 데이터에서 임의의 영어단어 하나 가져오기
        eword = wordMap.keys.random()  // 영어단어 배열에서 랜덤하게 하나를 선택

        // 영어단어를 화면에 보여주기
        findViewById<TextView>(R.id.eword).text = eword

        // 입력박스와 결과 텍스트 부분을 지우기(초기화)
        findViewById<EditText>(R.id.kword).text.clear()
        resultView.text = ""
    }
    // 사용자가 입력한 한글단어 뜻이 맞는지 확인하고 결과 출력
    fun checkAnswer() {
        // 입력박스에 입력한 한글단어 가져오기
        val word = findViewById<EditText>(R.id.kword).text.toString()

        // wordMap 에서 영어단어 해당하는 한글단어 가져오기(정답)
        val kword = wordMap[eword]

        // 정답인지 확인하기
        if (word == kword) {
            resultView.text = "정답이네요!"
            resultView.setTextColor(Color.BLUE)
            // 정답이면 2초 후에 다음 문제 출제하기
            resultView.postDelayed({
                displayWord()
            }, 2000)
        } else {
            resultView.text = "오답이네요!"
            resultView.setTextColor(Color.RED)
        }
    }
}








