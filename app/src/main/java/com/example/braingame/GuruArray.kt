package com.example.braingame

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*

class GuruArray(context: Context?, questions: ArrayList<Question>) : ArrayAdapter<Question?>(context!!, 0, questions!! as List<Question?>) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val ques = getItem(position)
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_question, parent, false)
        }
        val txtquestion = convertView!!.findViewById<View>(R.id.txtQuestion) as TextView
        txtquestion.text = ques!!.guruLine
        val txtInput = convertView.findViewById<View>(R.id.txtInput) as TextView
        txtInput.text = ques.input
        val itemLayout = convertView.findViewById<View>(R.id.itemLayout) as LinearLayout
        if (ques.status == Question.QStatus.Right) {
        } else if (ques.status == Question.QStatus.Wrong) {
            txtInput.append(String.format(" |A: %s", ques.ans))
        } else {
            itemLayout.setBackgroundColor(Color.parseColor("#DBA901"))
        }
        return convertView
    }
}