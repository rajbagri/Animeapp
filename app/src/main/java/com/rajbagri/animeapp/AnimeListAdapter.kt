package com.rajbagri.animeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AnimeListAdapter(
    context: Context,
    val hero: ArrayList<AnimeList>,
    private val picasso: Picasso,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<AnimeListAdapter.heroViewHolder>() {



    private val originalList: ArrayList<AnimeList> = ArrayList(hero)

    inner class heroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heroImage = itemView.findViewById<ImageView>(R.id.image_view_character_list)
        val heroName: TextView = itemView.findViewById(R.id.text_view_character_list)

        init {
            itemView.setOnClickListener { itemClickListener.onItemClick(bindingAdapterPosition, hero[bindingAdapterPosition].img) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): heroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_list, parent, false)
        return heroViewHolder(view)
    }

    override fun onBindViewHolder(holder: heroViewHolder, position: Int) {
        val imageUrl = hero[position].img
        holder.heroName.text = hero[position].charName
        picasso.load(imageUrl).
        into(holder.heroImage)
    }

    override fun getItemCount(): Int {
        return hero.size
    }

    fun filter(query: String?) {
        hero.clear()
        if (query.isNullOrEmpty()) {
            hero.addAll(originalList)
        } else {
            val filterPattern = query.lowercase().trim()
            originalList.forEach { item ->
                if (item.charName.lowercase().contains(filterPattern)) {
                    hero.add(item)
                }
            }
        }
    }


}
