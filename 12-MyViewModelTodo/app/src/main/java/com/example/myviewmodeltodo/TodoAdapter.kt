package com.example.myviewmodeltodo

// ===================================
// 4. RecyclerView Adapter
// ===================================
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.example.myviewmodeltodo.databinding.ItemTodoBinding

class TodoAdapter(
    private val onToggleClick: (Long) -> Unit,
    private val onDeleteClick: (Long) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private var todoList: List<Todo> = emptyList()

    fun submitList(newList: List<Todo>) {
        val diffCallback = TodoDiffCallback(todoList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        todoList = newList
        Log.d("TODO", todoList.toString())
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount() : Int {
        Log.d("SIZE", todoList.size.toString())
        return todoList.size
    }

    inner class TodoViewHolder(
        private val binding: ItemTodoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: Todo) {
            binding.apply {
                textViewTitle.text = todo.title
                checkBoxComplete.isChecked = todo.isCompleted

                // 완료된 항목은 텍스트에 취소선
                textViewTitle.paint.isStrikeThruText = todo.isCompleted

                // 체크박스 클릭
                checkBoxComplete.setOnClickListener {
                    onToggleClick(todo.id)
                }

                // 삭제 버튼 클릭
                buttonDelete.setOnClickListener {
                    onDeleteClick(todo.id)
                }
            }
        }
    }

    class TodoDiffCallback(
        private val oldList: List<Todo>,
        private val newList: List<Todo>
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
            return oldList[oldPos].id == newList[newPos].id
        }

        override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
            return oldList[oldPos] == newList[newPos]
        }
    }
}
