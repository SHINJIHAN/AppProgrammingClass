package com.example.tourapp

import java.io.Serializable // 객체 직렬화를 위한 인터페이스

open class TravelOption(val name: String, val price: Int) : Serializable // 구현한다

class HotelOption(name: String, price: Int,
                  val hasBreakfast: Boolean) : TravelOption(name, price) // 상속받는다

class ActivityOption(name: String, price: Int,
                     val hours: Int) : TravelOption(name, price)