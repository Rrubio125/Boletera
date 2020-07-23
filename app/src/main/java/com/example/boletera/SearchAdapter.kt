package com.example.boletera

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter (private val items:ArrayList<Categories>, private val onItemClick:(Categories) -> Unit ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.category, parent, false)
        return ViewHolder(View)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: Categories = items[position]
        when(holder) {
            is ViewHolder -> {
                holder.bind(item)
                holder.itemView.setOnClickListener{
                    onItemClick(item)
                }

            }
        }
    }

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        private var categories : TextView = view.findViewById(R.id.tv_categories)
        private var logo: ImageView = view.findViewById(R.id.iv_logo)

        fun bind(item: Categories){
            //picture.setImageResource(item.picture)
            categories.text = item.categories
            //logo.text = item.description
        }

    }
}
