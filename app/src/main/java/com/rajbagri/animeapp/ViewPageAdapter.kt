package com.rajbagri.tab_item

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rajbagri.animeapp.Categories
import com.rajbagri.animeapp.Home
import com.rajbagri.animeapp.Random


class ViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {



    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Categories()
            1 -> Home()
            else -> Random()


        }
    }






}