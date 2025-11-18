package com.example.seoultour

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // 멤버변수 선언
    // 1차원 정수 배열
    val photo = arrayOf(R.drawable.tour1, R.drawable.tour2, R.drawable.tour3,
        R.drawable.tour5, R.drawable.tour6, R.drawable.tour7,
        R.drawable.tour8, R.drawable.tour9, R.drawable.tour10, R.drawable.tour11)
    // 2차원 배열(원소 타입은 Any 타입)
    val places = arrayOf(arrayOf("경복궁", "서울특별시 종로구 세종로 사직로 161",
        "박물관과 정원이 있는 거대한 14세기 왕궁이며 무료 가이드 투어가 제공됩니다.", photo[0]),
        arrayOf("남산타워", "서울특별시 용산구 용산2가동 남산공원길 105",
            "1980년에 문을 연 이 상징적인 타워는 도심의 탁 트인 전망을 자랑하며 회전식 레스토랑을 이용할 수 있습니다.", photo[1]),
        arrayOf("익선동", "서울특별시 종로구", "카페거리와 볼거리가 많은 장소입니다.", photo[2]),
        arrayOf("롯데월드", "서울특별시 송파구 잠실동 올림픽로 240",
            "놀이기구, 물미끄럼틀, 해양생물 전시관을 한 곳에서 즐길 수 있는 가족형 어드벤처 파크입니다.", photo[3]),
        arrayOf("롯데타워", "서울특별시 송파구 잠실6동 올림픽로 300",
            "123층 높이의 대규모 초고층 건물에 고급 호텔과 멋진 전망을 볼 수 있는 전망대가 있습니다.", photo[4]),
        arrayOf("창덕궁", "서울특별시 종로구 와룡동 율곡로 99", "투어를 이용하여 조선 왕조의 궁전과 주변 정원을 둘러볼 수 있습니다.", photo[5]),
        arrayOf("북촌한옥마을", "서울특별시 종로구 계동 계동길 37", "세기를 재현해 놓은 마을로 좁은 골목을 따라 전통 가옥이 즐비해 있습니다.", photo[6]),
        arrayOf("서울숲공원", "서울특별시 성동구 성수동1가 뚝섬로 273",
            "나무가 많고 자전거 도로가 있는 넓은 공원으로 장미, 호수, 나비 정원이 있고 사슴에게 먹이를 줄 수 있습니다.", photo[7]),
        arrayOf("창덕궁", "서울특별시 종로구 서린동 청계천로 1",
            "책로, 다리, 녹지가 있는 휴식 공간으로 개울 주변으로 복원공사가 이루어졌습니다.", photo[8]),
        arrayOf("국립중앙박물관", "서울 용산구 서빙고로 137 (국립중앙박물관) ",
            "한국 역사와 문화의 정수가 살아 숨 쉬는 국립중앙박물관은 민족의 역사와 뿌리를 간직한 이 시대 최고의 문화 보고이자 역사의 현장입니다. " +
                    "전시와 교육을 통해 수천 년의 역사를 간직한 42만여 점 소장품들의 이야기를 들려주고, 보다 더 생생한 경험을 위해 " +
                    "디지털 실감 영상과 VR 체험을 제공하고 있습니다. 구석기시대의 소박한 손도끼에서부터 삼국시대의 화려한 금관, " +
                    "고려 시대의 청자, 조선시대의 회화, 근대의 사진들 나아가 세계 많은 나라들을 소개하는 세계 문화관까지. " +
                    "가족, 친구, 연인과 함께 국립중앙박물관에서 하루를 보내시는 건 어떠실까요?", photo[9]))
    lateinit var myPlaces: MutableList<Place>  // Place 객체들의 리스트 변수 선언
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Place 객체들의 리스트 생성하기
        setPlaceList()
        // PlaceAdapter 객체 생성하기
        val adapter = PlaceAdapter(this, myPlaces)
        // RecyclerView 참조하기
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val divide = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        recycler.addItemDecoration(divide)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }
    fun setPlaceList() {
        myPlaces = mutableListOf()  // Place 객체 리스트 생성하기
        for (i in 0..places.size - 1) {
            myPlaces.add(Place(places[i][0] as String,
                places[i][1] as String,
                places[i][2] as String, places[i][3] as Int
            ))
        }
    }
}







