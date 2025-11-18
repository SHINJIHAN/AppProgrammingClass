package com.example.activiylifecycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.Fruit

class MyAdapter(private val myData: List<Fruit>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    // MyViewHolder 객체를 생성 : 아이템뷰 템플릿(틀)을 생성
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        // 아이템뷰를 만들 레이아웃을 메모리로 가져옴
        val view = LayoutInflater.from(parent.context)
                                .inflate(R.layout.itemview, parent, false)
        return MyViewHolder(view)  // MyViewHolder 객체 생성(비어있는 아이템뷰 템플릿)
    }
    // 아이템뷰 템플릿에 데이터를 넣어서 목록 뷰를 생성
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val fruit = myData[position]
        holder.name.text = fruit.name  // 데이터 객체의 이름 값을 가져와서 화면에 표시
        holder.price.text = fruit.price.toString() + "원"
    }
    // 데이터 셋의 갯수
    override fun getItemCount() = myData.size

    // 아이템 뷰 홀더 클래스 : 데이터 목록의 각 항목 뷰를 정의
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.fruit_name) // 과일이름 표시할 자리
        val price = itemView.findViewById<TextView>(R.id.fruit_price)
    }
}