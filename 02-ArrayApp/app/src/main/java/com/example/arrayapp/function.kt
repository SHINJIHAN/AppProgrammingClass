package com.example.arrayapp

// import kotlin.random.Random
import java.nio.file.Files.size
import  java.util.Random

fun main() {
//    print("반지름 : ")
//    val r = readln().toInt()    // 변수선언에 val, var 키워드 사용
//    val size = getSize(r, 3.14)  // 함수호출(함수에게 기능 수행하도록 요구).실매개변수(인자 argument)
//    println("면적 = $size")
//    val sizeSum = getAllSize(3, 5, 8)
//    val sizeSum2 = getAllSize(4, 9, 13, 7, 2)

    // 예제2: 로또번호 생성하고 출력하기
    val lotto = Array(6){0} // 길이 6개 정수 원소들의 배열 생성
    makeLotto(lotto) // 로또번호 생성해서 lotto 배열의 저장됨
    printLotto(lotto.sorted()) // 로또번호 출력하기

    // 받는 부분이 없음 --> 리턴 받아야 함.
    val lotto2 = makeLotto()
    printLotto(lotto2.sorted())
}

fun makeLotto() : List<Int> { // 함수중복정의(Function Overloading)
    val lotto = mutableListOf<Int>() // 변경가능한 정수형 리스트 생성
    val random = Random()
    for (i in 0 ..5) { // size 없음
        var num = 0
        while (true) {
            num = random.nextInt(45) + 1
            if (!lotto.contains(num)) break;
        }
        lotto.add(num) // 리스트에 원소 추가하기
    }
    return  lotto
}

fun makeLotto(lotto: Array<Int>) {
    // 1~45 사이의 숫자를 랜덤하게 선출해서 lotto 배열에 담기
    val random = Random()
    for (i in 0 until lotto.size) {
        var num = 0
        while (true) {
            num = random.nextInt(45) + 1
            if (!lotto.contains(num)) break;
        }
        lotto[i] = num
    }
}
fun printLotto(lotto: List<Int>) { // 매개변수를 콜랙션 리스트 객체로 받음
    print("[ ")
    for (num in lotto) print("$num ")
    println("]")
}

fun convertDegree(c: Int) : Int {
    return (c * 1.8 + 32).toInt()
}

// 디폴트 파라미터
fun getSize(x: Int, pi: Double = 3.14) : Double { // 형식매개변수(paramrter)에는 val, var 사용 안함
    // x = 7 // 매개변수는 변경 안됨. 읽기만 가능 val 선언됨
    var y = x
    y += 3
    return x * x * pi
}

fun getAllSize(vararg args: Int): Double { // 가변길이 매개변수. args 변수는 배열로 생성
    var total = 0.0
    for (r in args) { // foreach 구문으로 배열에서 원소를 하나씩 가져오기
        total += getSize(r, 3.1415)
    }
    return total
}
