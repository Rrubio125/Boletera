package com.example.boletera

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.boletera.Event
import com.example.boletera.R

class EventAdapter (private val items:ArrayList<Event>, private val onItemClick:(Event) -> Unit ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.events, parent, false)
       return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
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
        private var picture : ImageView = view.findViewById(R.id.iv_image)
        private var title: TextView = view.findViewById(R.id.tv_event_name)
        private var description: TextView = view.findViewById(R.id.tv_event_descripcion)

        fun bind(item: Event){
            //picture.setImageResource(item.picture)
            title.text = item.title
            description.text = item.description

        }

    }

}