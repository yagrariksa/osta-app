package com.main.osta_unair.data

import android.content.res.Resources
import com.main.osta_unair.R
import com.main.osta_unair.model.Tips

class News {

    val listNews: List<Tips> = listOf(
        Tips(
            R.string.tips_1_title,
            R.array.tips_1,
        ),
        Tips(
            R.string.tips_2_title,
            R.array.tips_2,
        ),
        Tips(
            R.string.tips_3_title,
            R.array.tips_3
        )
    )

    fun fetchText(resources: Resources, array: Int): String{
        var str: String = ""
        val arr = resources.getStringArray(array)
        arr.forEach {
            str = str + "\u0009${it}" + "\n\n"
        }
        return str
    }

    fun getShort(resources: Resources, array: Int): String {
        var str: String = ""
        var arr = resources.getStringArray(array)
        var one = arr[0].split('.')
        str = one[0]
        return str
    }
}