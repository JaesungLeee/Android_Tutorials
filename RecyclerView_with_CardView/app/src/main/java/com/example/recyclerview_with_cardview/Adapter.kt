package com.example.recyclerview_with_cardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class Adapter(val arrayList: ArrayList<Model>, val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model: Model) {

            itemView.titleTv.text = model.title
            itemView.descriptionTv.text = model.des
            itemView.image.setImageResource(model.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {
            if (position == 0) {
                Toast.makeText(context, "TOP", Toast.LENGTH_SHORT).show()
            }
            else if (position == 1) {
                Toast.makeText(context, "BOTTOM", Toast.LENGTH_SHORT).show()
            }
            else if (position == 2) {
                Toast.makeText(context, "OUTER", Toast.LENGTH_SHORT).show()
            }
            else if (position == 3) {
                Toast.makeText(context, "DRESS", Toast.LENGTH_SHORT).show()
            }
        }
    }
}