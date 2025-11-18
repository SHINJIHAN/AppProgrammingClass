package com.example.myviewmodel.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    // 외부 데이터 담을 라이브데이터 생성
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    // 네트워크에서 데이터 가져오기하는 함수
    fun fetchData() {
        // 외부 API 호출하는 코드. Retrofit 라이브러리를 사용
        // 단순히 3초후에 라이브데이터 설정하는 코드로 작성
        Handler(Looper.getMainLooper()).postDelayed({
            _data.value = "서버에서 받아온 데이터..."  // 나중에는 외부 서버에서 데이터 가져오기를 함
        }, 3000)  // 3초 후에 동작하도록 설정
    }
}









