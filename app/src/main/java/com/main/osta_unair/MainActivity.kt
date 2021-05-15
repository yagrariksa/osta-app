package com.main.osta_unair

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.main.osta_unair.databinding.ActivityMainBinding
import com.main.osta_unair.ui.calcu.CalcuBottomSheetDialog
import com.main.osta_unair.ui.calcu.CalcuFragment
import com.main.osta_unair.ui.level.Level
import com.main.osta_unair.ui.level.LevelBottomSheetDialog
import com.main.osta_unair.ui.level.LevelFragment
import com.main.osta_unair.ui.news.NewsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val pages = listOf(
        CalcuFragment { data1, data2, data3 -> calcuBottomDialog(data1, data2, data3) },
        LevelFragment(this) { item -> levelBottomDialog(item)},
        NewsFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        loadFragment(pages[0])
         */

        val adapter = MainPageAdapter(supportFragmentManager, pages)
        val viewPager = binding.vpMain
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //
            }

            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> {
                        binding.btmNav.selectedItemId = R.id.menu_item_calcu
                    }
                    1 -> {
                        binding.btmNav.selectedItemId = R.id.menu_item_level
                    }
                    2 -> {
                        binding.btmNav.selectedItemId = R.id.menu_item_news
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        binding.btmNav.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId) {
                    R.id.menu_item_calcu -> {
                        viewPager.currentItem = 0
                        return true
                    }
                    R.id.menu_item_level -> {
                        viewPager.currentItem = 1
                        return true
                    }
                    R.id.menu_item_news -> {
                        viewPager.currentItem = 2
                        return true
                    }
                }
                return false
            }

        })

    }


    private fun calcuBottomDialog(data1: String, data2: String, data3: String) {
        val dd = CalcuBottomSheetDialog(data1,data2,data3)
        dd.show(supportFragmentManager, "CALCU_BOTTOM_DIALOG")
    }

    private fun levelBottomDialog(item: Level) {
        val dd = LevelBottomSheetDialog(item)
        dd.show(supportFragmentManager, "LEVEL_BOTTOM_DIALOG")
    }
}


