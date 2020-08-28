package com.example.recyclerview_with_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = ArrayList<Model>()
        arrayList.add(Model("Top", "Check your Top clothing", R.drawable.topwear))
        arrayList.add(Model("Bottom", "Check your Bottom clothing", R.drawable.bottomwear))
        arrayList.add(Model("Outer", "Check your Outer clothing", R.drawable.outerwear))
        arrayList.add(Model("Dress", "Check your Dress clothing", R.drawable.dresswear))

        val myAdapter = Adapter(arrayList, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter
    }
}