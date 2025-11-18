package com.example.arrayapp

fun main() {
//    //배열 생성
//    val arr = arrayOf(3, 6, 12, 23, 44, 6, 9, 8, 6)
//
//    //원소 접근
//    val b = arr[1] + arr[3] + 1
//    arr[2] = 13
//
//    // 배열 순회
//    for (i in 0..arr.size - 1)   // for(int i=0; i< arr.length; i++)
//        // print("$arr[i] ")
//        print("${arr[i]} ")
//    println()                         // Enter
//
//    for (i in 0 until arr.size)  // 색인으로 반복
//        print("${arr[i]} ")
//    println()
//
//    for (a in arr)                    // 원소값으로 반복. foreach 구문
//        print("$a ")
//    println()
//
//    for (i in arr.indices)
//        print("$i : ${arr[i]} ")
//    println()
//
//    for ((i, a) in arr.withIndex())
//        print("$i : $a ")
//    println()
//
//    // 탐색
//    print("Number to find : ")
//    val num = readln().toInt()
//    var cnt = 0
//    for (a in arr) {
//        if (a == num) cnt++
//    }
//    println("count = $cnt")
//    println()
//
//    val found = arr.contains(num)       // 존재여부
//    println("found ? $found")
//    println()
//
//    val position = arr.indexOf(num)     // 첫번째 색인
//    println("position ? $position")
//    println()

    // 리스트
    val list = listOf(5, 7, 3, 11, 5)     // Readonly. 변경분가능한 리스트
    // list[1] = 9
    val x = list[2] + 3
    val mlist = mutableListOf<Double>(2.1, 8.5)
    mlist[0] = 3.3
    mlist.add(5.6)
    mlist.add(7.3)
    mlist.add(1.9)
    mlist.add(11.3)
    mlist.remove(7.3)
    for (m in mlist)
        print("$m ")
}