package com.main.osta_unair

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.main.osta_unair.ui.calcu.CalcuFragment
import com.main.osta_unair.ui.level.LevelFragment

@Suppress("DEPRECATION")
class MainPageAdapter(fm: FragmentManager, private val pages: List<Fragment>): FragmentPagerAdapter(fm) {


    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }
}