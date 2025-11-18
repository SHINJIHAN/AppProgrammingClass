package com.example.myviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myviewmodel.databinding.ActivityMainBinding
import com.example.myviewmodel.viewmodel.DataViewModel
import com.example.myviewmodel.viewmodel.MyViewModel
import com.example.myviewmodel.viewmodel.MyViewModelLive

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0  // 데이터 생성
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
        /* 1) 기존방식 : 메인액티비티가 데이터 생성하고 계산하고 출력 등 모든 것 처리 방식
        binding.up.setOnClickListener {
            count++    // 계산(로직) 처리
            binding.textCount.text = count.toString()  // 뷰에 출력(UI 처리)
        }
        binding.down.setOnClickListener {
            binding.textCount.text = (--count).toString()
        }
        binding.reset.setOnClickListener {
            count = 0
            binding.textCount.text = count.toString()
        }*/
        /* 2) 뷰모델 생성 - 뷰모델을 통해 데이터와 기능을 이용
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        binding.textCount.text = viewModel.count.toString()
        binding.up.setOnClickListener {
            binding.textCount.text = viewModel.increment().toString()
        }
        //viewModel.count = 12   // 뷰모델의 데이터에 직접 변경 가능 */
        val viewModelLive = ViewModelProvider(this).get(MyViewModelLive::class.java)
        val observer = Observer<Int> {  // 정수값 관찰자 생성
            // 관찰자가 관찰하는 정수값의 변화가 있으면 아래 일을 수행
            binding.textCount.text = viewModelLive.count.value.toString()
        }
        // 뷰모델의 라이브데이터에 관찰자 설정
        viewModelLive.count.observe(this, observer)
        binding.up.setOnClickListener {
            viewModelLive.increment()
        }
        // DataViewModel 이용
        val dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        dataViewModel.data.observe(this, Observer { newData -> // 새로 변경된 라이브데이터 값
            binding.textCount.text = newData
        })
        dataViewModel.fetchData()
    }
}










