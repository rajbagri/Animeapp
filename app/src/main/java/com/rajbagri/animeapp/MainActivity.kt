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
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.rajbagri.tab_item.ViewPager
import com.squareup.picasso.Picasso
import com.squareup.picasso.OkHttp3Downloader  // Import the OkHttp3Downloader class

class MainActivity : AppCompatActivity() {


    private lateinit var progressBar: ProgressBar
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentStateAdapter

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




        tabLayout = findViewById(R.id.tab_layout)
        viewPager2 = findViewById(R.id.view_pager)


        adapter = ViewPager(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Categories"

                }
                1 -> {
                    tab.text = "Home"
                }
                2 -> {
                    tab.text = "Random"
                }
            }
        }.attach()


//        progressBar = findViewById(R.id.progress_bar_main)

        // Initialize Picasso with caching using OkHttp3Downloader

    }



//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu, menu)
//
//        val searchItem = menu.findItem(R.id.action_search)
//        val searchView = searchItem.actionView as SearchView
//
//        // Handle search query changes
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                // Filter your data based on the newText
//                adapter.filter(newText) // Assuming you have a filter method in your adapter
//                return true
//            }
//        })
//
//        return true
//    }






}



