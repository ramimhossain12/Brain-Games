package com.example.braingame

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

//import android.app.Fragment;
class KeyboardFragment : Fragment() {
    interface NumpadListener {
        fun onNumClick(input: Int)
        fun onDelClick()
        fun onDelHold()
        fun onEntClick()
        fun onMinusClick()
    }

    var listener: NumpadListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            val activity = context as Activity
            activity as NumpadListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString()
                    + " must implement NumpadListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_keyboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val btn0 = view!!.findViewById<View>(R.id.button0) as Button
        btn0.setOnClickListener { if (listener != null) listener!!.onNumClick(0) }
        val btn1 = view!!.findViewById<View>(R.id.button1) as Button
        btn1.setOnClickListener { if (listener != null) listener!!.onNumClick(1) }
        val btn2 = view!!.findViewById<View>(R.id.button2) as Button
        btn2.setOnClickListener { if (listener != null) listener!!.onNumClick(2) }
        val btn3 = view!!.findViewById<View>(R.id.button3) as Button
        btn3.setOnClickListener { if (listener != null) listener!!.onNumClick(3) }
        val btn4 = view!!.findViewById<View>(R.id.button4) as Button
        btn4.setOnClickListener { if (listener != null) listener!!.onNumClick(4) }
        val btn5 = view!!.findViewById<View>(R.id.button5) as Button
        btn5.setOnClickListener { if (listener != null) listener!!.onNumClick(5) }
        val btn6 = view!!.findViewById<View>(R.id.button6) as Button
        btn6.setOnClickListener { if (listener != null) listener!!.onNumClick(6) }
        val btn7 = view!!.findViewById<View>(R.id.button7) as Button
        btn7.setOnClickListener { if (listener != null) listener!!.onNumClick(7) }
        val btn8 = view!!.findViewById<View>(R.id.button8) as Button
        btn8.setOnClickListener { if (listener != null) listener!!.onNumClick(8) }
        val btn9 = view!!.findViewById<View>(R.id.button9) as Button
        btn9.setOnClickListener { if (listener != null) listener!!.onNumClick(9) }
        val btndel = view!!.findViewById<View>(R.id.buttonDel) as Button
        btndel.setOnClickListener { if (listener != null) listener!!.onDelClick() }
        btndel.setOnLongClickListener {
            if (listener != null) listener!!.onDelHold()
            true
        }
        val btnent = view!!.findViewById<View>(R.id.buttonEnt) as Button
        btnent.setOnClickListener { if (listener != null) listener!!.onEntClick() }
        val btnMinus = view!!.findViewById<View>(R.id.buttonMinus) as Button
        btnMinus.setOnClickListener { if (listener != null) listener!!.onMinusClick() }
    }
}