package com.example.musicalbum

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: AlbumAdapter? = null
    private var albumList: MutableList<Album> = mutableListOf()  // 비어있는 객체 생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 1) RecyclerView reference 가져오기
        recyclerView = findViewById(R.id.recycler_view)
        // 2) AlbumAdapter 객체 생성하기
        adapter = AlbumAdapter(this, albumList)  // albumList는 비어있는 리스트
        // 3) RecyclerView에 레이아웃매니저 등록
        recyclerView?.layoutManager = GridLayoutManager(this, 2)
        // 4) RecyclerView에 어댑터 등록
        recyclerView?.adapter = adapter
        // 5) albumList 데이터 생성(추가)
        prepareAlbums()
    }
    private fun prepareAlbums() {
        val covers = intArrayOf(
            R.drawable.album1,
            R.drawable.album2,
            R.drawable.album3,
            R.drawable.album4,
            R.drawable.album5,
            R.drawable.album6,
            R.drawable.album7,
            R.drawable.album8,
            R.drawable.album9,
            R.drawable.album10,
            R.drawable.album11)
        var a = Album("Love poem", 1, covers[0])
        albumList!!.add(a)
        a = Album("CHANNEL 8", 11, covers[1])
        albumList!!.add(a)
        a = Album("Purpose-The 2nd Album", 12, covers[2])
        albumList!!.add(a)
        a = Album("항해", 10, covers[3])
        albumList!!.add(a)
        a = Album("Rewind", 5, covers[4])
        albumList!!.add(a)
        a = Album("Feel Special", 7, covers[5])
        albumList!!.add(a)
        a = Album("Speak Your Mind", 17, covers[6])
        albumList!!.add(a)
        a = Album("I met you when I was 18", 17, covers[7])
        albumList!!.add(a)
        a = Album("Hello", 11, covers[8])
        albumList!!.add(a)
        a = Album("Greatest Hits", 17, covers[9])
        albumList!!.add(a)
        adapter!!.notifyDataSetChanged()  // 어댑터에게 데이터리스트의 변경을 통지하는 기능
    }
}






