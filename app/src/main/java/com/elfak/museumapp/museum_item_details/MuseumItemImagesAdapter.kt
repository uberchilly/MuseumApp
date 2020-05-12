package com.elfak.museumapp.museum_item_details

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.elfak.museumapp.R
import com.squareup.picasso.Picasso

class MuseumItemImagesAdapter constructor(private val images: List<String>) :
    RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val imageView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image_pager, parent, false) as ImageView
        return ItemViewHolder(imageView)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(images[position])
    }
}

class ItemViewHolder(private val view: ImageView) : RecyclerView.ViewHolder(view) {

    internal fun bind(imageUrl: String) {
        Picasso.get().load(imageUrl).placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder).into(view)
    }
}