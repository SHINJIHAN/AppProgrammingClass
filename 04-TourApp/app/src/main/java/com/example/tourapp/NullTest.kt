package com.example.tourapp

fun main() {
    val name: String? = null
    val name2: String = "melon"
    val size: Int? = name?.length  // 널 안전연산자
    val size2 = name2.length
    //name!!.uppercase()   // 널 단정연산자. NPE 발생함
    val size3 = name?.length ?: 0
    val size4 = if (name != null) name.length else 0
    println("size = $size3")
    // 타입변환
    val code: Any = "AB342"
    val num: Any = 33.89  // Double
    val code2: String? = code as? String?
    val code3: String? = num as? String?
    println("code = $code2, code3 = $code3")
    val data: String? = "Kiwi"
    if (data != null) {
        val data2: String = data   // 스마트 캐스팅
    }
}








