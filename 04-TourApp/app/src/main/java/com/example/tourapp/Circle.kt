package com.example.tourapp
// open 키워드. 부모클래스
open class Circle(var r: Int) {
    open val x = 0  // 자식클래스에서 변수의 초기값 및 get, set 함수 변경
    open var y = 0
    open fun calcSize() : Double {  // 재정의 허용
        return r * r * 3.14
    }
}
// 자식클래스
class ColorCircle(r: Int, var color: String? = null) : Circle(r) {
    override val x = 3
    override var y: Int = 2   // 부모에게 받은 멤버변수의 초기값과 get, set 변경
        get() {
            return field
        }
        set(value) {
            field = value + 3
        }
    override fun calcSize(): Double {  // 부모에게 받은 메소드를 재정의 한다.
        val radius = r * 2
        return radius * radius * 3.141516
    }
}
fun main() {
    val c = ColorCircle(7)
    val c2 = ColorCircle(4, "RED")
    println("size = ${c.calcSize()}")
}