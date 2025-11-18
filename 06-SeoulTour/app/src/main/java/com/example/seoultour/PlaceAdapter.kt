package com.example.seoultour

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceAdapter(val context: Context, val myPlaces: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(  // MyViewHolder 객체 생성하기
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context)
                            .inflate(R.layout.item_view, parent, false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(  // MyViewHolder 객체에 값을 배정하기
        holder: MyViewHolder,
        position: Int
    ) {
        val place = myPlaces.get(position)
        holder.title.text = place.title
        holder.address.text = place.address
        holder.photo.setImageResource(place.photo)
        // 아이템뷰의 클릭 처리
        holder.itemview.setOnClickListener {
            val intent = Intent(context, PlaceActivity::class.java)
            intent.putExtra("TITLE", place.title)
            intent.putExtra("ADDR", place.address)
            intent.putExtra("DESC", place.desc)
            intent.putExtra("PHOTO", place.photo)
            // Place 객체를 인텐트에 직접 저장하기(객체 직렬화)
            intent.putExtra("PLACE", place)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = myPlaces.size

    inner class MyViewHolder(val itemview: View) : RecyclerView.ViewHolder(itemview) {
        // 아이템뷰의 데이터 값이 표시될 뷰들의 참조 생성
        val title = itemview.findViewById<TextView>(R.id.item_title)
        val address = itemview.findViewById<TextView>(R.id.item_address)
        val photo = itemview.findViewById<ImageView>(R.id.item_photo)
    }
}