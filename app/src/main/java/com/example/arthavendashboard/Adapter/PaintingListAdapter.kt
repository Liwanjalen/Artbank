package com.example.arthavendashboard.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arthavendashboard.Model.Painting
import com.example.arthavendashboard.R
import com.squareup.picasso.Picasso

class PaintingListAdapter (private val paintings: List<Painting>) : RecyclerView.Adapter<PaintingListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val paintingImage: ImageView = itemView.findViewById(R.id.painting_image)
        val paintingName: TextView = itemView.findViewById(R.id.painting_title)
        val paintingPrice: TextView = itemView.findViewById(R.id.painting_price)
        val paintingArtist: TextView = itemView.findViewById(R.id.artist_name)
        val paintingDescription: TextView = itemView.findViewById(R.id.painting_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val painting = paintings[position]

        holder.paintingName.text = painting.name
        //holder.paintingPrice.text = painting.price
        holder.paintingArtist.text = painting.artist
        //holder.paintingDescription.text = painting.description

        Picasso.get().load(painting.imageUrl).into(holder.paintingImage)
    }

    override fun getItemCount(): Int {
        return paintings.size
    }
}