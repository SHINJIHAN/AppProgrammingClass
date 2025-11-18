package com.example.activiylifecycle

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.activiylifecycle.MyAdapter
import com.example.listapp.Fruit

class MainActivity : AppCompatActivity() {
    // 데이터 셋을 생성
    private val myData = mutableListOf<Fruit>()
    private val fruits = listOf("사과\n\t25000원, 등급: 상","바나나","레몬","딸기","자몽","체리","자두",
                    "복숭아","귤","수박","단감","복숭아","귤","수박","단감", "복숭아","귤","수박","단감")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 1. myData 데이터 셋 생성하기
        setMyData()
        // 2. RecyclerView 참조 가져오기
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        // 3. MyAdapter 객체 생성하기
        val adapter = MyAdapter(myData)
        // 4. RecyclerView에 어댑터 연결하기
        recycler.adapter = adapter

        /*
        // 1. ListView 참조 가져오기
        val listView = findViewById<ListView>(R.id.listview)
        // 2. ArrayAdapter 생성하기
        val adapter = ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, fruits)
        // 3. ListView에 ArrayAdapter 연결하기
        listView.adapter = adapter
        // 4. 아이템 항목 선택을 위한 클릭이벤트 처리하기
        listView.setOnItemClickListener { parent, view, position, id ->
            //val fruit = fruits[position]
            val fruit = parent.getItemAtPosition(position)
            Toast.makeText(this, "선택된 과일: $fruit", Toast.LENGTH_LONG).show()
        }*/
    }
    fun setMyData() {
        myData.add(Fruit("사과", 24500))
        myData.add(Fruit("체리", 24500))
        myData.add(Fruit("바나나", 24500))
        myData.add(Fruit("멜론", 24500))
        myData.add(Fruit("복숭아", 24500))
    }
}





