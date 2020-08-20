package com.example.horizontalrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data: MutableList<DataObject> = ArrayList()
        for (i in 1..10)
            data.add(DataObject("title $i"))

        val LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapter = CustomAdapter(data)

        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

    }
}