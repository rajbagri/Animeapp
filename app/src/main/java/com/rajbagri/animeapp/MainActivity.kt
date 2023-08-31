package com.rajbagri.animeapp


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import android.widget.ProgressBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso
import com.squareup.picasso.OkHttp3Downloader  // Import the OkHttp3Downloader class

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimeListAdapter
    private lateinit var heroList: ArrayList<AnimeList>
    private lateinit var picasso: Picasso
    private lateinit var progressBar: ProgressBar
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.drawerArrowDrawable.setColor(resources.getColor(R.color.white))
        toggle.syncState()





        recyclerView = findViewById(R.id.recycler_view_character_list)
        heroList = ArrayList()

//        progressBar = findViewById(R.id.progress_bar_main)

        // Initialize Picasso with caching using OkHttp3Downloader
        picasso = Picasso.Builder(this)
            .indicatorsEnabled(true) // Enable debugging indicators
            .loggingEnabled(true)    // Enable logging
            .downloader(OkHttp3Downloader(this)) // Use OkHttp3Downloader for caching
            .build()

        setupList()
    }

    override fun onItemClick(position: Int, imageUrl: String) {
        val intent = Intent(this, FullImageActivity::class.java)
        intent.putExtra("image_url", heroList[position].img)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        // Handle search query changes
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Filter your data based on the newText
                adapter.filter(newText) // Assuming you have a filter method in your adapter
                return true
            }
        })

        return true
    }


    private fun setupList() {
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/641/837/HD-wallpaper-goku-ultra-instinct-dragon-ball-super-dragon-ball-anime.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/866/615/HD-wallpaper-goku-ani-anime-ball-black-blue-dbz-dragon-dragon-ball-super-ultra.jpg"))

        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/1000/265/HD-wallpaper-solo-leveling-manhwa-king-of-shadows-manga-anime-sung-jin-woo.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/881/217/HD-wallpaper-jujutsu-kaisen-wallpap-jujustu-kaisen-anime-jjk-anime-anime.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/668/176/HD-wallpaper-gohan-ssj2-anime-ball-dragon.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/28/814/HD-wallpaper-sasuke-uchiha-naruto-sasuke-uchiha.jpg"))

        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/176/620/HD-wallpaper-itachi-uchiha-naruto-shippuden-anime.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/736/818/HD-wallpaper-demon-slayer-anime-sword.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/730/126/HD-wallpaper-sung-jin-woo-solo-leveling.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/827/858/HD-wallpaper-satoru-gojo-gojo-gojo-satoru-jujutsu-kaisen-satoru-satoru-gojo-yuji-itadori.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/526/133/HD-wallpaper-nezuko-demon-slayer-kimetsu-no-yaiba.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/447/978/HD-wallpaper-itachi-uchiha-sasuke-sasuke-uchiha-anime-kakashi-naruto-anime-naruto-uzumaki.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/943/193/HD-wallpaper-demon-slayer-anime-demon-slayer.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/996/54/HD-wallpaper-sung-jin-woo-anime-dark-manga-manwha-shadow-shadow-king-shadow-lord-solo-leveling.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/153/316/HD-wallpaper-shanks-and-luffy-anime-aesthetic-brook-chopper-nami-one-piece-roronoa-zoro-vinsmoke-sanji.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/487/532/HD-wallpaper-one-piece-sanji-anime-one-piece-vinsmoke-sanji.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/809/935/HD-wallpaper-nezuko-kamado-demon-slayer-kimetsu-no-yaiba-muzan-tanjiro-zenitsu.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/735/163/HD-wallpaper-gojo-satoru-anime-cool-gojou-itadori-yuji-jujutsu-jujutsu-kaisen-kaisen-manga.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/611/249/HD-wallpaper-zoro-one-piece-one-piece.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/409/730/HD-wallpaper-the-ultimate-fusion-dbz-dragon-ball-dragon-ball-super-dragon-ball-z-gogeta.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/376/277/HD-wallpaper-roronoa-zoro-anime-luffy-onepiece-sword.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/591/880/HD-wallpaper-ryomen-sukuna-jujutsu-kaisen-edit-jjk-jujutsu-kaisen.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/771/714/HD-wallpaper-sasuke-uchiha-uchiha-clan-black-hair-flash-graphy-anime-uchiha-sasuke-naruto-shippuuden-naruto.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/334/580/HD-wallpaper-sukuna-curse-demon-jujutsu-jujutsu-kaisen.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/356/830/HD-wallpaper-uchiha-madara-anime-naruto-warrior.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/968/860/HD-wallpaper-anime-anime-boys-in.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/511/50/HD-wallpaper-mode-baryon-naruto-sasuke-minato-itachi-naruto-shippuden-boruto-uzumaki.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/398/491/HD-wallpaper-one-piece-zoro-anime-one-piece-roronoa-zoro-wano-zorojuro.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/830/396/HD-wallpaper-gojo-and-yuji-aesthetic-city-jujutsu-kaisen-satoru-gojo-sukuna-yuji-itadori.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/47/637/HD-wallpaper-goku-dragon-ball-dragon-ball-gt-dragon-ball-super-dragon-ball-z.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/602/639/HD-wallpaper-son-gohan-dbl-ultimate-gohan.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/554/825/HD-wallpaper-rengoku-demon-slayer.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/844/654/HD-wallpaper-anime-anime-boy-umbrella.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/932/801/HD-wallpaper-goku-ultra-instinct-dragonball-super-son-goku-ultra-instinct-goku-power-thumbnail.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/430/829/HD-wallpaper-anime-anime-boys-in.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/310/461/HD-wallpaper-boruto-boruto-uzumaki-sasuke-sasuke-uchiha-uchiha-naruto-shippuden-uzumaki.jpg"))
        heroList.add(AnimeList("","https://www.peakpx.com/en/hd-wallpaper-desktop-vdxno"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/834/991/HD-wallpaper-anime-boys-anime-girls-anime-vertical-couple-hand-on-neck.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/194/642/HD-wallpaper-solo-leveling-manga-solo-leveling.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/804/478/HD-wallpaper-anime-boy-girl-couple-silhouette-background-anime-couple.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/884/72/HD-wallpaper-solo-leveling-manga-scan-solo-leveling.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/341/176/HD-wallpaper-solo-leveling-anime-cosmic-manga-manwha-shadow-sung-jin-woo.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/899/977/HD-wallpaper-kyojuro-rengoku-demon-demon-slayer-kimetsu-kimetsu-no-yaiba-season-2-slayer-yaiba.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/6/929/HD-wallpaper-solo-leveling-aesthetic-manhwa-sung-jin-woo.jpg"))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/335/803/HD-wallpaper-igris-anime-maneha-manga-solo-leveling-sung-jin-woo.jpg"))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
        heroList.add(AnimeList("","https://w0.peakpx.com/wallpaper/703/1012/HD-wallpaper-kakashi-x-susanoo-anime-itachi-uchiha-kakashi-edit-kakashi-hatake-kakashi-susanoo-manga-naruto-shippuden-naruto-uzumaki-sasuke-uchiha.jpg"))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))
//        heroList.add(AnimeList("",""))

        adapter = AnimeListAdapter(this, heroList, picasso, this)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter
    }



}



