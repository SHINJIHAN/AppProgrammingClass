package com.example.myviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 데이터 클래스 정의
data class Number(var count: Int = 0)

class MyViewModelLive : ViewModel() {
    private val _number = MutableLiveData<Number>(Number(0))
    val number = _number
    // 캡슐화 기법으로 데이터 생성
    private var _count = MutableLiveData<Int>() // count는 변경가능한 라이브데이터 객체
    val count: LiveData<Int> = _count
    init {  // MyViewModelLive 객체 생성할 때 실행되는 초기화 블록
        _count.value = 0
    }
    // 기능 정의
    fun increment() {
        _count.value = _count.value!! + 1  // count.value는 Int? 타입이므로
        val current = _number.value?.count ?: 0    // 현재 Number 객체의 count 값
        _number.value = Number( current + 1) // 하나 증가된 Number 객체
    }
    fun decrement() {
        _count.value = (_count.value ?: 0) - 1
        val current = _number.value?.count ?: 0    // 현재 Number 객체의 count 값
        _number.value = Number( current - 1)
    }
    fun reset() {
        _count.value = 0
        _number.value = Number(0)
    }
}