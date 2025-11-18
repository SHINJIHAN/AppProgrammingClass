package com.example.helloapp

fun main() {
    /*
    println("Hello, Kotlin!")
    val msg = "Android!"
    println("Hello, " + msg) // 문자열 연결
    println("Hello, ${msg}") // 문자열 템플릿
    val point = 1000
    println("Your point = ${point + 1000}")

    // 키보드 입력하기
    var age: Int = 0
    print("age : ")
    age = readln().toInt()
    println("Your age is ${age}")

    //스캐너 객체로 입력 받기
    val scn = Scanner(System.in)
    //var num: Double 또는
    var num = 0.0

    num = scn.nextDouble()
    println("Num = ${num}")
*/

    //d원 면적 구하기
    var r = 0
    print("Radius : ")
    r = readln().toInt()
    val PI = 3.1415
    val size = r * r * PI
    val length = 2 * r * PI
    println("원의 면적 = ${size}, 둘레 = ${length}")
}