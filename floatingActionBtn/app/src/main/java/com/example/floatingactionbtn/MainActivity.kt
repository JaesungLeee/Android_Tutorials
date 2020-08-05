package com.example.floatingactionbtn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)
        val fabRClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise)
        val fabRAntiClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_anticlockwise)

        add_btn.setOnClickListener {

            if (isOpen) {
                edit_btn.startAnimation(fabClose)
                photo_btn.startAnimation(fabClose)
                add_btn.startAnimation(fabRClockwise)

                isOpen = false
            }

            else {
                edit_btn.startAnimation(fabOpen)
                photo_btn.startAnimation(fabOpen)
                add_btn.startAnimation(fabRAntiClockwise)

                edit_btn.isClickable
                photo_btn.isClickable

                isOpen = true
            }

            edit_btn.setOnClickListener {
//                Toast.makeText(this, "EDIT", Toast.LENGTH_SHORT).show()
                var intent = Intent(applicationContext, account::class.java)
                startActivity(intent)
            }

            photo_btn.setOnClickListener {
//                Toast.makeText(this, "PHOTO", Toast.LENGTH_SHORT).show()
                var intent = Intent(applicationContext, clothes::class.java)
                startActivity(intent)
            }
        }
    }
}