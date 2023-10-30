package com.example.vk_task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val rectangles: MutableList<Int>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_rectangle, null)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rectangles.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val number = rectangles[position]
        holder.numberText.text = number.toString()
        holder.square.setBackgroundResource(if (number % 2 == 0) R.color.red else R.color.blue)
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val square: View = itemView.findViewById(R.id.square)
        val numberText: TextView = itemView.findViewById(R.id.numberText)
    }

}