package com.example.mystorage

import android.R.attr.name
import android.R.attr.text
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mystorage.databinding.ActivitySqliteBinding

class SqliteActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySqliteBinding
    private val dbHelper = MySQLiteHelper(this)  // SQLite DB(mydb) 생성하고 onCreate 실행
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySqliteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // DB에 데이터 저장하기
        binding.btnInsert.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0
            dbHelper.insertUser(name, age)
            binding.etName.text.clear()
            binding.etAge.text.clear()
        }
        // user 데이터 모두 가져오기
        binding.btnLoad.setOnClickListener {
            val users = dbHelper.getAllUsers()
            val sb = StringBuilder()
            users.forEach {
                (name, age) -> sb.append("$name / $age \n")
            }
            binding.tvSqliteResult.text = sb.toString()
        }
    }
}









