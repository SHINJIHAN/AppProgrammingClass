package com.example.wordapp

// Rect class 정의
class Rect(var w: Int, var h: Int) // 자바로는 10줄을 한 줄로 작성

// Circle class 정의
class Circle(var r: Double) { // 클래스명 뒤에 바로 주생성자 정의. 멤버변수 선언 이면서 주생성자 매개변수
    // var r: Double = r // 멤버변수 선언
    // 부생성자(secondary) 정의

    // 생성자 정의
//    constructor(r: Double){
//        this.r = r // 보라색 멤버변수
//    }

    fun calcSize() : Double { // 메소드 정의
        return r * r * 3.14
    }
}
fun main() {
    val c = Circle(3.5) // 객체 생성 (new 연산자 사용 안함, 디폴트 생성자: 컴파일러가 자동 생성.)
    // c.r = 7.3 // c.setR(7.3) 실행하는 것과 같음
    println("r = ${c.r}, size = ${c.calcSize()}")

    val r = Rect(5, 9)
    println("w = ${r.w}, h = ${r.h}, size = ${r.w * r.h}")
}
