package com.main.osta_unair

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.main.osta_unair.databinding.ActivityMainBinding
import com.main.osta_unair.databinding.DialogCalcuBinding
import com.main.osta_unair.ui.calcu.CalcuBottomSheetDialog
import com.main.osta_unair.ui.calcu.CalcuFragment
import com.main.osta_unair.ui.level.LevelFragment
import com.main.osta_unair.ui.news.NewsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var calcuFragment: CalcuFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calcuFragment =
            CalcuFragment { data1, data2, data3 -> calcuBottomDialog(data1, data2, data3) }
        loadFragment(calcuFragment)

        binding.btmNav.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.menu_item_level -> {
                    loadFragment(LevelFragment())
                }
                R.id.menu_item_calcu -> {
                    loadFragment(calcuFragment)
                }
                R.id.menu_item_news -> {
                    loadFragment(NewsFragment())
                }
                else -> {
                    loadFragment(calcuFragment)
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.flMain.id, fragment, fragment.javaClass.simpleName)
                .commit()
            return true
        }

        return false
    }

    private fun calcuBottomDialog(data1: String, data2: String, data3: String) {
//        val dd = CalcuBottomSheetDialog(data1,data2,data3)
//        dd.show(supportFragmentManager, "BOTTOM_FRAG")
        loadFragment(CalcuBottomSheetDialog(data1, data2, data3))
    }
}

