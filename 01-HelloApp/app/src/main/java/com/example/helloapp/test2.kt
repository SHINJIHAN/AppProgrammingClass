package com.example.helloapp

fun main() {
    // print("키(cm): ")
    // val cm = readLine()!!.toDouble()
    // // readdln().toInt()
    //
    // val inch = cm / 2.54
    // val feet = (inch / 12).toInt()
    // // feet: Int
    //
    // val remainingInch = inch % 12
    // // inch = inch % 12
    //
    // println("$feet 피트 ${"%.2f".format(remainingInch)}인치")
    // // String.format("%.1f", inch)인치")
    //
    // if문 처리: 다중 if 문
    // var position = ""
    // if (feet < 5) position = "First Row"
    // else if (feet >= 5 && feet < 7) position = "Second Row"
    // else position = "Third RoW"
    // println("position : $position")
    //
    // val position = if (feet < 5) "First Row"
    // else if (feet >= 5 && feet < 7) {
    //     var a = 5
    //     val b = a + 5
    //     "Second Row"
    // }
    // else "Third Row"
    // println("position : $position")
    //
    // when 구문
    // var position = ""
    // when {
    //     feet < 5 -> position = "First Row"
    //     feet >= 5 && feet < 7 -> position = "Second Row"
    //     else -> position = "Third Row"
    // }
    // println("position : $position")
    //
    // when 수식
    // val position = when {
    //     feet < 5 -> {
    //         "First Row"
    //     }
    //     feet >= 5 && feet < 7 -> "Second Row"
    //     else -> "Third Row"
    // }
    // println("position : $position")
    //
    // 사칙연산 계산기
    // print("First number : ")
    // val num1 = readln().toDouble()
    // print("Operator : ")
    // val op = readln()
    // print("Second number : ")
    // val num2 = readln().toDouble()
    //
    // when 수식 처리
    // val result = when (op) {
    //     "+" -> num1 + num2
    //     "-" -> num1 - num2
    //     "*" -> num1 * num2
    //     "/" -> if (num2 != 0.0) num1 / num2 else "Second number is zero"
    //     else -> "invalid operator"
    // }
    // println("Result = $result")
    //
    // 월에 따른 계절 출력
    // print("Month : ")
    // val month = readln().toInt()
    // val season = when (month) {
    //     in 3..5 -> "Spring" // 범위 채크
    //     in 6..8 -> "Summer"
    //     in 9..11 -> "Fall"
    //     12, 1, 2 -> "Winter" // 매칭된 값들을 나열할 수 있음
    //     else -> "Invalid month"
    // }
    // println("${month}월은 ${season}이다.")

    val text = "2025년 Winter입니다."
    println(String(text.toByteArray(Charsets.UTF_8), Charsets.UTF_8))
}
