package com.example.myviewmodeltodo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myviewmodeltodo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TodoViewModel
    private lateinit var adapter: TodoAdapter

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

        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        setupRecyclerView()
        observeViewModel()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        adapter = TodoAdapter(
            onToggleClick = { todoId ->
                viewModel.toggleTodoComplete(todoId)
            },
            onDeleteClick = { todoId ->
                viewModel.deleteTodo(todoId)
            }
        )

        binding.recyclerViewTodos.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    private fun observeViewModel() {
        // Todo 리스트 관찰
        viewModel.todoList.observe(this, Observer { todos ->
            adapter.submitList(todos)
            updateStatistics()
        })

        // 에러 메시지 관찰
        viewModel.errorMessage.observe(this, Observer { message ->
            message?.let {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupClickListeners() {
        // 추가 버튼
        binding.buttonAdd.setOnClickListener {
            val title = binding.editTextTodo.text.toString()
            viewModel.addTodo(title)
            binding.editTextTodo.text?.clear()
        }

        // 완료된 항목 삭제 버튼
        binding.buttonDeleteCompleted.setOnClickListener {
            viewModel.deleteCompletedTodos()
        }
    }

    private fun updateStatistics() {
        val total = viewModel.getTotalCount()
        val completed = viewModel.getCompletedCount()
        binding.textViewStats.text = "완료: $completed / 전체: $total"
    }
}
