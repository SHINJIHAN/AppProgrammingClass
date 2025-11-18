package com.example.helloapp

fun main() {

    // 반복문 종류
//    var n = 0       // 반복제어변수 초기화: 시작값을 설정
//    var sum = 0
//    while (n < 5) { // 제어변수를 활용한 조건식
//        sum += 2
//        n++         // 제어변수 변경하기 // 무한 반복에 걸림
//    }
//    println("Sum = ${sum}")

    var sum = 0
    // for (int i = 0; i < 5; i++)   // 자바 구문
    // for (i in 0..4)               // 제어변수: i
    // for (i in 0 until 5 step 2)   // i += 2
    // for (i in 4 downTo 0)
//    repeat(5) { index ->
//        sum += 2
//    }
//    //    sum +=2
//    println("$sum : $index")

//    // 조건문에 따른 반복구문
//    var n = 0
//    while (n < 20) {
//        print("Your number : ")
//        n = readln().toInt()
//    }

    // 예제: 정수값을 6번 입력받을 때 3의 배수 시 누적해서 총합 구하고 출력하기.
    // 단 3의 배수이며 동시에 5의 배수인 숫자는 제외하기
    // 총합의 값이 30이면 그만두기.
    var total = 0
    // repeat(6)
    for (i in 0 .. 5) {
        print("Number: ")
        val num = readln().toInt()
        if (num % 3 == 0 && num % 5 == 0) continue // 다음 반복으로 넘어감
        if (num % 3 == 0 && num % 5 != 0 ) total += num
        if (total >= 30) break
    }
    println("Total = $total")

}