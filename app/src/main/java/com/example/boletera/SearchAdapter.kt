package com.example.boletera

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SearchAdapter(
    private val items: ArrayList<EventCategory>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: EventCategory = items[position]
        when (holder) {
            is ViewHolder -> {
                holder.bind(item)
                holder.itemView.setOnClickListener {
                    onItemClick(item.getNameForCategory(it.context))
                }

            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var categoriesTextView: TextView = view.findViewById(R.id.tv_category_name)
        private var iconImageView: ImageView = view.findViewById(R.id.iv_category_icon)
        private var cardLayout: ConstraintLayout = view.findViewById(R.id.category_background)

        fun bind(item: EventCategory) {
            categoriesTextView.text = item.getNameForCategory(categoriesTextView.context)
            Glide.with(iconImageView.context).load(item.getIconResourceForCategory())
                .into(iconImageView)
            cardLayout.setBackgroundColor(item.getColorForCategory())
        }

    }
}
