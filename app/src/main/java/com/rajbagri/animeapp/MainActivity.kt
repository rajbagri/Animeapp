package com.rajbagri.animeapp

import AnimeListAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimeListAdapter
    private lateinit var heroList: ArrayList<AnimeList>
    private lateinit var picasso: Picasso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view_character_list)
        heroList = ArrayList()

        // Initialize Picasso with custom configuration
        picasso = Picasso.Builder(this)
            .indicatorsEnabled(true) // Enable debugging indicators
            .loggingEnabled(true)    // Enable logging
            .build()

        setupList()
    }

    private fun setupList() {
        heroList.add(AnimeList("sasuke", "https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg"))
        heroList.add(AnimeList("sasuke", "https://images.pexels.com/photos/17847276/pexels-photo-17847276/free-photo-of-close-up-of-bee-head.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"))
        heroList.add(AnimeList("Levi","https://images.pexels.com/photos/17809421/pexels-photo-17809421/free-photo-of-stars-in-galaxy.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"))
        heroList.add(AnimeList("Levi","https://images.pexels.com/photos/17693467/pexels-photo-17693467/free-photo-of-fish-and-coral-reef-on-seabed.jpeg?auto=compress&cs=tinysrgb&w=400"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/anime-city-43g4mfdzm6c5jzb8.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/kaneki-ken-in-red-bricks-siz3e0yyy8jaiamb.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/anime-girl-gppx4o6tlx03lgz5.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/anime-qljvylod6i5ikhxg.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/3840x2160-anime-phone-hd-amazing-mac-desktop-background-wallpaper-of-iphone-1fjoy2o323hcikv5.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/2560x1600-nice-anime-wallpaper-in-high-quality-72diuf3qcqger4og.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/4098x2304-anime-universe-image-anime-characters-hd-wallpaper-and-background-6q0wwu9gf52hvl9h.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/black-and-white-anime-boy-1ijp8z07aascdge7.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/dreaming-boy-anime-a9bq35afd2h46zjt.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/naruto-s-sage-mode-3jylx0ao9beesbb0.webp"))
        heroList.add(AnimeList("Levi","https://wallpapers.com/images/high/naruto-shippuden-sasuke-uchiha-ciub2zbnxsygaca0.webp"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP._3FEtsKDDd-QkYTjQvwpCQHaEo?w=268&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.4JV4CSi7dKO8wcLfPLE_RwHaEK?w=298&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.aj3yjp6FqkXXtxVKqr4xHwHaEo?w=266&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.pzBDd7Y8i54IPMasl3xtYQHaEK?w=278&h=182&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.01_rapNLx8WCc8LbPnA32wHaEK?w=257&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.oxnbSJ6xDGPTTyhtbYEAjQHaEK?w=281&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.Zg3gtZNT5psFR0UGnH0rOgHaEK?w=283&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.nDw17LbvGkJ3DKv7GaLkOgHaEK?w=236&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.6e0HjbDct8Wg4UoFGHdK9gHaEA?w=299&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.dYtEso5LHIUlqZKSDF9xTQHaEK?w=230&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.SyYIvHg4LMsvAeVypr-IZwHaEK?w=322&h=181&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.1VxgoJr1D635fkjYbVvG6AHaEK?w=298&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.uDwZ7_WYb2g44a_BExtIswHaEK?w=284&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.fwXw3tS0zp1L8ZDDunBMVAHaEK?w=298&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))
        heroList.add(AnimeList("Levi","https://th.bing.com/th/id/OIP.bRgYAQroNwRjBqDmlsp2NgHaEo?w=268&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"))

        adapter = AnimeListAdapter(this, heroList, picasso, this)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int, imageUrl: String) {
        val intent = Intent(this, FullImageActivity::class.java)
        intent.putExtra("image_url", heroList[position].img)
        startActivity(intent)
    }
}
