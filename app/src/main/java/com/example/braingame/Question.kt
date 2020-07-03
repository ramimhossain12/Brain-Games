package com.example.braingame

class Question(var num1: Int, var num2: Int, var num3: Int, var num4: Int, var num5: Int, var num6: Int,
               var oper1: Char, var oper2: Char, var oper3: Char, var oper4: Char, var oper5: Char, var ans: Int, //question number
               var count: Int) {
    enum class QStatus {
        Unanswered, Wrong, Right
    }

    var input = ""
    var status: QStatus
    fun getnum1(): Int {
        return num1
    }

    val noviceLine: String
        get() = String.format("%d)  %d %c %d= ", count, num1, oper1, num2)

    val easyLine: String
        get() = String.format("%d)  %d %c %d %c %d= ", count, num1, oper1, num2, oper2, num3)

    val mediumLine: String
        get() = String.format("%d)  %d %c %d %c %d %c %d= ", count, num1, oper1, num2, oper2, num3, oper3, num4)

    val guruLine: String
        get() = String.format("%d)  %d %c %d %c %d %c %d %c %d= ", count, num1, oper1, num2, oper2, num3, oper3, num4, oper4, num5)

    init {
        status = QStatus.Unanswered
    }
}