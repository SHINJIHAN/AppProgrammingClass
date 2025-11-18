package com.example.myviewmodeltodo

// ===================================
// 2. Repository (데이터 소스 관리)
// ===================================
class TodoRepository {
    private var todoIdCounter = 0L

    fun createTodo(title: String): Todo {
        return Todo(
            id = ++todoIdCounter,
            title = title,
            isCompleted = false
        )
    }
}
