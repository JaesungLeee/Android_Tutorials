package com.example.floatingactionbutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.fab_rotate_open_anim)}
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.fab_rotate_close_anim)}
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.fab_from_menu_anim)}
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.fab_to_menu_anim)}

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu_faBtn.setOnClickListener {
            onAddButtonClicked()
        }

        emergency_faBtn.setOnClickListener {
//            Toast.makeText(applicationContext, "Emergency faBtn", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, emergency::class.java)
            startActivity(intent)
        }

        logout_faBtn.setOnClickListener {
            Toast.makeText(applicationContext, "Logout faBtn", Toast.LENGTH_SHORT).show()
        }

    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            emergency_faBtn.startAnimation(fromBottom)
            logout_faBtn.startAnimation(fromBottom)
            menu_faBtn.startAnimation(rotateOpen)
        }
        else {
            emergency_faBtn.startAnimation(toBottom)
            logout_faBtn.startAnimation(toBottom)
            menu_faBtn.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            emergency_faBtn.visibility = View.VISIBLE
            logout_faBtn.visibility = View.VISIBLE
        }
        else {
            emergency_faBtn.visibility = View.INVISIBLE
            logout_faBtn.visibility = View.INVISIBLE
        }
    }

    private fun setClickable(clicked: Boolean) {
        if (!clicked) {
            emergency_faBtn.isClickable = true
            logout_faBtn.isClickable = true
        }
        else {
            emergency_faBtn.isClickable = false
            logout_faBtn.isClickable = false
        }
    }

}