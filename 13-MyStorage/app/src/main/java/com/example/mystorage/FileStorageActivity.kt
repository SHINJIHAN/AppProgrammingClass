package com.example.mystorage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mystorage.databinding.ActivityFileStorageBinding

class FileStorageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFileStorageBinding
    private val FILENAME = "memo.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFileStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 파일에 데이터 기록하기
        binding.btnFileSave.setOnClickListener {
            val text = binding.etFile.text.toString()
            // 파일 기록용으로 열기(최초에는 파일을 생성해줌)
            openFileOutput(FILENAME, MODE_PRIVATE).use { fos -> // 파일 포인터
                fos.write(text.toByteArray())  // 문자열을 바이트배열로 변환해서 기록하기
                fos.write(" Cold Winter!".toByteArray())
            }
            binding.etFile.text.clear()
        }
        // 파일로부터 데이터 읽어오기
        binding.btnFileLoad.setOnClickListener {
            val text = try {  // 예외처리 구문(try ~ catch 구문)
                openFileInput(FILENAME).bufferedReader().readText() // 파일 내용 한번에 읽어오기
            } catch (e: Exception) {
                "$FILENAME 파일이 없습니다"
            }
            binding.tvFileResult.text = text
        }
    }
}










