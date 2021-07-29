package com.main.osta_unair

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.main.osta_unair.databinding.ActivityMainBinding
import com.main.osta_unair.ui.calcu.CalcuBottomSheetDialog
import com.main.osta_unair.ui.calcu.CalcuFragment
import com.main.osta_unair.model.Level
import com.main.osta_unair.model.Tips
import com.main.osta_unair.ui.level.LevelBottomSheetDialog
import com.main.osta_unair.ui.level.LevelFragment
import com.main.osta_unair.ui.news.NewsBottomSheetDialog
import com.main.osta_unair.ui.news.NewsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var btmNav: BottomNavigationView

    private val pages = listOf(
        CalcuFragment(this) { data1, data2, data3, data4, data5, data6 ->
            calcuBottomDialog(
                data1,
                data2,
                data3,
                data4,
                data5,
                data6
            )
        },
        LevelFragment(this) { item -> levelBottomDialog(item) },
        NewsFragment(this) { news -> newsBottomDialog(news) }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /** Error while rotting*/
        setContentView(R.layout.activity_main)

        /*
        loadFragment(pages[0])
         */

        val adapter = MainPageAdapter(supportFragmentManager, pages)
        btmNav = findViewById(R.id.btm_nav);
        viewPager = findViewById(R.id.vp_main)
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
                when (position) {
                    0 -> {
                        btmNav.selectedItemId = R.id.menu_item_calcu
                    }
                    1 -> {
                        btmNav.selectedItemId = R.id.menu_item_level
                    }
                    2 -> {
                        btmNav.selectedItemId = R.id.menu_item_news
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        btmNav.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
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

    private fun readMore() {
        btmNav.selectedItemId = R.id.menu_item_level
        viewPager.currentItem = 1
    }

    private fun calcuBottomDialog(
        tanggal: String,
        berat: String,
        tinggi: String,
        kelamin: String,
        usia: String,
        level: Level
    ) {
        val dd =
            CalcuBottomSheetDialog(tanggal, berat, tinggi, kelamin, usia, level) { -> readMore() }
        dd.show(supportFragmentManager, "CALCU_BOTTOM_DIALOG")
    }

    private fun levelBottomDialog(item: Level) {
        val dd = LevelBottomSheetDialog(item)
        dd.show(supportFragmentManager, "LEVEL_BOTTOM_DIALOG")
    }

    private fun newsBottomDialog(item: Tips) {
        val dd = NewsBottomSheetDialog(item, resources)
        dd.show(supportFragmentManager, "NEWS_BOTTOM_DIALOG")
    }

}


