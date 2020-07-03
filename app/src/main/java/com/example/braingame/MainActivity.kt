package com.example.braingame

import android.app.Activity
import android.app.DialogFragment
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.braingame.AboutDialog.DialogListener

@Suppress("DEPRECATION")
class MainActivity : Activity(), DialogListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun newgame(v: View?) {
        val intent = Intent(this, QuestionMode::class.java)
        startActivity(intent)
    }

    fun about(v: View?) {
        val dialog: DialogFragment = AboutDialog()
        dialog.show(fragmentManager, getString(R.string.tag_about))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //menu item selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (item.itemId == R.id.feedbackID) {

            startActivity(intent)
        } else if (id == R.id.abID) {
            val intent = Intent(this, AboutDialog::class.java)
            startActivity(intent)
            return true
        } else if (id == R.id.dateId) {
            val intent = Intent(this, DatePicker::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}