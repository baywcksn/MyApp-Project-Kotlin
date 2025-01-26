package com.example.myapp_project_kotlin

import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ListFoodAdapter(private val listFood: ArrayList<Food>) : RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Fungsi untuk mengatur callback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_food, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listFood[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        // Ketika item diklik
        holder.itemView.setOnClickListener {
            // Intent untuk berpindah ke DetailActivity
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            // Kirim data ke DetailActivity
            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_DESCRIPTION", description)
            intent.putExtra("EXTRA_PHOTO", photo)

            // Mulai DetailActivity
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listFood.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    // Interface untuk callback
    interface OnItemClickCallback {
        fun onItemClicked(data: Food)
    }
}