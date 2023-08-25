package com.example.testovoe22

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter(private val context: Context, var lessons: List<CoursesItem>) :
    RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(coursesItem: CoursesItem)
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.textViewName.text = lesson.title
        holder.textViewQuantity.text = "Quantity:"
        holder.textViewKolvo.text = lesson.kolvo
        holder.arrow.setImageResource(R.drawable.arrow)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, LessonsActivity::class.java)
            intent.putExtra("course", lesson)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val arrow: ImageView = itemView.findViewById(R.id.galka)
        val textViewQuantity: TextView = itemView.findViewById(R.id.textViewQuantity)
        val textViewKolvo: TextView = itemView.findViewById(R.id.textViewKolvo)
    }
}