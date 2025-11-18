package com.example.myviewmodel.viewmodel
// androix - 제트팩 라이브러리(기능이 확장된 라이브러리)
import androidx.lifecycle.ViewModel

// 데이터(모델)을 정의하고 데이터를 처리할 기능(Controller)을 가지는 뷰모델
class MyViewModel : ViewModel() {
    // 데이터 생성
    private var _count = 0 // private - 내부에서만 사용되는 변수이고 읽기 쓰기 가능
    //val count = _count  // 캡슐화 기법 : 외부에서 접근 가능한 변수는 읽기전용으로 함
    val count: Int
        get() = _count
    // 계산 기능 함수 정의
    fun increment() = ++_count
    fun decrement() = --_count
    fun reset() {
        _count = 0
    }
}