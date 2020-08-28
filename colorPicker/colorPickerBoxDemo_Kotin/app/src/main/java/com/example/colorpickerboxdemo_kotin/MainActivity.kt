package com.example.colorpickerboxdemo_kotin

import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import petrov.kristiyan.colorpicker.ColorPicker
import petrov.kristiyan.colorpicker.ColorPicker.OnChooseColorListener
import java.util.*

class MainActivity : AppCompatActivity() {

    var mainlayout: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainlayout = findViewById(R.id.layout)

        var changeBtn: Button = findViewById(R.id.colorPicker_btn)

        changeBtn.setOnClickListener {
            openColorPicker()
        }
    }

    private fun openColorPicker() {
        val colorPicker = ColorPicker(this)
        val color = ArrayList<String>()

        color.add("#258174")
        color.add("#3C8D2F")
        color.add("#20724F")
        color.add("#6A3AB2")
        color.add("#323299")
        color.add("#800080")
        color.add("#b79716")
        color.add("#966d37")
        color.add("#b77231")
        color.add("#808000")

        colorPicker.setColors(color)
                .setTitle("You can choose maximum 4 colors")
                .setColumns(5)
                .setRoundColorButton(true)
                .setOnChooseColorListener(object : OnChooseColorListener {
                    override fun onChooseColor(position: Int, color: Int) {
                        mainlayout?.setBackgroundColor(color)
                    }

                    override fun onCancel() {}
                }).show()

    }
}