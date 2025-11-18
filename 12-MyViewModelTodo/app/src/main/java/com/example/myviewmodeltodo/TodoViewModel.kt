package com.example.myviewmodeltodo

// ===================================
// 3. ViewModel
// ===================================
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TodoViewModel : ViewModel() {

    private val repository = TodoRepository()

    // Todo 리스트를 관리하는 LiveData
    private val _todoList = MutableLiveData<List<Todo>>(emptyList())
    val todoList: LiveData<List<Todo>> = _todoList

    // 입력 필드의 에러 메시지
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    // Todo 추가
    fun addTodo(title: String) {
        if (title.isBlank()) {
            _errorMessage.value = "할 일을 입력해주세요"
            return
        }

        _errorMessage.value = null
        val newTodo = repository.createTodo(title)
        val currentList = _todoList.value ?: emptyList()
        _todoList.value = currentList + newTodo
    }

    // Todo 완료 상태 토글
    fun toggleTodoComplete(todoId: Long) {
        val currentList = _todoList.value ?: return
        _todoList.value = currentList.map { todo ->
            if (todo.id == todoId) {
                todo.copy(isCompleted = !todo.isCompleted)
            } else {
                todo
            }
        }
    }

    // Todo 삭제
    fun deleteTodo(todoId: Long) {
        val currentList = _todoList.value ?: return
        _todoList.value = currentList.filter { it.id != todoId }
    }

    // 완료된 항목 모두 삭제
    fun deleteCompletedTodos() {
        val currentList = _todoList.value ?: return
        _todoList.value = currentList.filter { !it.isCompleted }
    }

    // 통계 정보
    fun getTotalCount(): Int = _todoList.value?.size ?: 0
    fun getCompletedCount(): Int = _todoList.value?.count { it.isCompleted } ?: 0
}
