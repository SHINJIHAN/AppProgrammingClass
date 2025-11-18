package com.example.myviewmodeltodo

// ===================================
// 1. Model (데이터 클래스)
// ===================================
data class Todo(
    val id: Long,
    val title: String,
    val isCompleted: Boolean = false
)
