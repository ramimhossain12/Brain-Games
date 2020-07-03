package com.example.braingame

import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.braingame.KeyboardFragment.NumpadListener
import com.example.braingame.ScoreFragment.ScoreListener
import java.util.*
import java.util.concurrent.TimeUnit

class Novice : FragmentActivity(), NumpadListener, ScoreListener {
    var Length = 10 //changes number of questions
    var Count = 1
    var nCorrect = 0
    var timeElapsed: Long = 0
    var timeFormat = ""
    var quizOver = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_quiz)
        val listView = findViewById<View>(R.id.listView) as ListView
        listView.divider = null
        val q1 = getQuizQuestion(Count)
        val listQuestions = ArrayList<Question>()
        listQuestions.add(q1)
        val adapter = NoviceArray(this, listQuestions)
        listView.adapter = adapter
        val Progress = findViewById<View>(R.id.Progress) as TextView
        Progress.text = String.format("%d / %d", Count, Length)
        if (savedInstanceState == null) {
            val numpadFrag = KeyboardFragment()
            supportFragmentManager.beginTransaction().add(R.id.numpadContainer, numpadFrag).commit()
        }
    }

    override fun onStart() {
        super.onStart()
        if (!quizOver) {
            val quizTimer = findViewById<View>(R.id.chronometer) as Chronometer
            quizTimer.base = SystemClock.elapsedRealtime() - timeElapsed
            quizTimer.start()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        if (!quizOver) {
            val quizTimer = findViewById<View>(R.id.chronometer) as Chronometer
            timeElapsed = SystemClock.elapsedRealtime() - quizTimer.base
            quizTimer.stop()
        }
        super.onStop()
    }

    override fun onNumClick(input: Int) {
        try {
            val listView = findViewById<View>(R.id.listView) as ListView
            val adapter = listView.adapter as NoviceArray
            val item = adapter.getItem(Count - 1)
            val prevInput = item!!.input
            item.input = prevInput + String.format("%d", input)
            adapter.notifyDataSetChanged()
            listView.smoothScrollToPosition(Count - 1)
        } catch (e: Exception) {
        }
    }

    override fun onMinusClick() {
        try {
            val listView = findViewById<View>(R.id.listView) as ListView
            val adapter = listView.adapter as NoviceArray
            val item = adapter.getItem(Count - 1)
            val prevInput = item!!.input
            if (prevInput.contains("-")) {
            } else {
                item.input = "-$prevInput"
            }
            adapter.notifyDataSetChanged()
            listView.smoothScrollToPosition(Count - 1)
        } catch (e: Exception) {
        }
    }

    override fun onDelClick() {
        try {
            val listView = findViewById<View>(R.id.listView) as ListView
            val adapter = listView.adapter as NoviceArray
            val item = adapter.getItem(Count - 1)
            val prevInput = item!!.input
            if (prevInput.length != 0) {
                item.input = prevInput.substring(0, prevInput.length - 1)
                adapter.notifyDataSetChanged()
                listView.smoothScrollToPosition(Count - 1)
            }
        } catch (e: Exception) {
        }
    }

    override fun onDelHold() {
        try {
            val listView = findViewById<View>(R.id.listView) as ListView
            val adapter = listView.adapter as NoviceArray
            val item = adapter.getItem(Count - 1)
            val prevInput = item!!.input
            if (prevInput.length != 0) {
                item.input = ""
                adapter.notifyDataSetChanged()
                listView.smoothScrollToPosition(Count - 1)
            }
        } catch (e: Exception) {
        }
    }

    override fun onEntClick() {
        try {
            val listView = findViewById<View>(R.id.listView) as ListView
            val adapter = listView.adapter as NoviceArray
            val item = adapter.getItem(Count - 1)
            val strInput = item!!.input
            if (strInput.length != 0) {
                val intInput = strInput.toInt()
                if (intInput == item.ans) {
                    item.status = Question.QStatus.Right
                    nCorrect++
                    val result = findViewById<View>(R.id.result) as TextView
                    result.text = "CORRECT!"
                    result.setTextColor(Color.parseColor("#04B404"))
                } else {
                    item.status = Question.QStatus.Wrong
                    val result = findViewById<View>(R.id.result) as TextView
                    result.text = "INCORRECT!"
                    result.setTextColor(Color.parseColor("#DF0101"))
                }
                adapter.notifyDataSetChanged()
                if (Count < Length) {
                    Count++
                    val q1 = getQuizQuestion(Count)
                    adapter.add(q1)
                    listView.smoothScrollToPosition(Count - 1)
                } else {
                    quizOver = true
                    val quizTimer = findViewById<View>(R.id.chronometer) as Chronometer
                    timeElapsed = SystemClock.elapsedRealtime() - quizTimer.base
                    quizTimer.stop()
                    timeFormat = String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes(timeElapsed),
                            TimeUnit.MILLISECONDS.toSeconds(timeElapsed) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeElapsed))
                    )
                    val resultsFrag = ScoreFragment()
                    val args = Bundle()
                    args.putInt(ScoreFragment.Ext_Score, nCorrect)
                    args.putInt(ScoreFragment.Ext_Length, Length)
                    args.putString(ScoreFragment.Ext_Time, timeFormat)
                    resultsFrag.arguments = args
                    supportFragmentManager.beginTransaction().replace(R.id.numpadContainer, resultsFrag).commit()
                }
            }
        } catch (e: Exception) {
        }
    }

    override fun MainMenu() {
        finish()
    }

    fun getQuizQuestion(count: Int): Question {
        val rand = Random()
        val intOper = rand.nextInt(4)
        var num1 = 0
        var num2 = 0
        var ans = 0
        val num3 = 0
        val num4 = 0
        val num5 = 0
        val num6 = 0
        var oper1 = '+'
        val oper2 = '-'
        val oper3 = '×'
        val oper4 = '÷'
        val oper5 = '+'
        when (intOper) {
            0 -> {
                oper1 = '+'
                num1 = rand.nextInt(30) + 1
                num2 = rand.nextInt(30) + 1
                ans = num1 + num2
            }
            1 -> {
                oper1 = '-'
                num1 = rand.nextInt(30) - 6
                num2 = rand.nextInt(num1) + 1
                ans = num1 - num2
            }
            2 -> {
                oper1 = '×'
                num1 = rand.nextInt(15) + 1
                num2 = rand.nextInt(15) + 1
                ans = num1 * num2
            }
            3 -> {
                oper1 = '÷'
                val factors = ArrayList<Int>()
                do {
                    num1 = rand.nextInt(97) + 4
                    var limit = num1
                    var i = 2
                    while (i < limit) {
                        if (num1 % i == 0) {
                            factors.add(i)
                            limit = num1 / i
                            factors.add(limit)
                        }
                        i++
                    }
                } while (factors.size == 0) //if num1 is prime
                val index = rand.nextInt(factors.size)
                num2 = factors[index]
                ans = num1 / num2
            }
        }
        return Question(num1, num2, num3, num4, num5, num6, oper1, oper2, oper3, oper4, oper5, ans, count)
    }
}