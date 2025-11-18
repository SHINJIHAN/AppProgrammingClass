package com.example.musicalbum

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.toString

class AlbumAdapter(val context: Context, val albumList: MutableList<Album>) :
    RecyclerView.Adapter<AlbumAdapter.MyViewHolder>() {
    // 아이템뷰 객체를 생성하기 위한 내부 클래스 정의
    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var title: TextView = itemview.findViewById(R.id.title)
        var songs: TextView = itemview.findViewById(R.id.count)
        var thumbnail: ImageView = itemview.findViewById(R.id.thumbnail)
        var overflow: ImageView = itemview.findViewById(R.id.overflow)
    }
    // 아이템뷰 객체 생성하는 메소드
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // 아이템뷰 소스 레이아웃 파일(xml)을 파싱해서 메모리에 객체로 생성하는 것
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.album_card, parent, false)
        return MyViewHolder(itemview)  // 아이템뷰 객체 생성
    }
    // 아이템뷰 객체에 데이터를 바인딩하는 메소드
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val album = albumList[position]
        holder.title.text = album.name
        holder.songs.text = album.numOfSongs.toString()
        holder.thumbnail.setImageResource(album.thumbnail)
        holder.overflow.setOnClickListener {
            showPopupMenu(holder.overflow, album)
        }
    }
    // 아이템 목록의 개수
    override fun getItemCount(): Int {
        return albumList.size
    }

    fun showPopupMenu(view: View, album: Album) {
        // PopupMenu 객체 생성
        val popup = PopupMenu(context, view)
        popup.menuInflater.inflate(R.menu.menu_album, popup.menu)
        // 메뉴아이템 기능 추가
        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_play -> {
                    val player = MediaPlayer.create(context, R.raw.lovepoem)
                    if (player != null) {
                        player.start()
                        player.setOnCompletionListener { // 노래 재생이 완료되었을 때 할일
                            it.seekTo(0)  // 노래 파일의 처음으로 돌아감
                            it.stop()
                        }
                    }
                    true
                }
                R.id.menu_web -> {
                    var url = ""
                    if (album.name == "Love poem")
                        url = "https://www.youtube.com/watch?v=OcVmaIlHZ1o&list=RDOcVmaIlHZ1o&start_radio=1"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                    true
                }
                else -> true
            }
        }
        popup.show()  // 팝업메뉴 보이기
    }
}








