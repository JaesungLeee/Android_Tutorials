package com.example.horizontalrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_view.view.*

class CustomAdapter (
    private val data: List<DataObject>
) :  RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    private val items: MutableList<CardView>

    init {
        this.items = ArrayList()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int { return data.size }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = data[position].title

        items.add(holder.card)
    }

    inner class ViewHolder
    internal constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.tvTitle
        val card: CardView = itemView.card
    }
}