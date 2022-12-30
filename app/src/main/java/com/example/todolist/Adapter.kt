package com.example.todolist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*
import android.content.Intent as Intent

class Adapter(var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.title
        var priority = itemView.priority
        var layout = itemView.mylayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
    return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        when (data[position].priority.toLowerCase()) {
            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#f05454"))
            "medium" -> holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
        }


        holder.title.text = data[position].title
        holder.priority.text = data[position].priority

     holder.itemView.setOnClickListener{
         val intent = Intent(holder.itemView.context,UpdateCard::class.java )
         intent.putExtra("id", position)
      holder.itemView.context.startActivity(intent)
     }

    }

    override fun getItemCount(): Int {
        return data.size
    }


}