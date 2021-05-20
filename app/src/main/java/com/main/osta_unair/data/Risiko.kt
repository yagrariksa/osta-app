package com.main.osta_unair.data

import com.main.osta_unair.R
import com.main.osta_unair.model.Level

class Risiko {
    val rendah: Level = Level(
        "Low Risk",
        R.string.rendah_short,
        R.string.rendah_long,
        R.color.result_green,
        R.string.rendah_expl,
        R.string.rendah_short,
    )

    val sedang: Level = Level(
        "Medium Risk",
        R.string.sedang_short,
        R.string.sedang_long,
        R.color.result_yellow,
        R.string.sedang_expl,
        R.string.sedang_short,
    )

    val tinggi: Level = Level(
        "High Risk",
        R.string.tinggi_short,
        R.string.tinggi_long,
        R.color.result_red,
        R.string.tinggi_expl,
        R.string.tinggi_short,
    )

    val listLevel: List<Level> = listOf(
        rendah, sedang, tinggi
    )

    val table: List<List<Level>> = listOf(
        listOf(sedang, rendah, rendah, rendah, rendah, rendah, rendah, rendah),
        listOf(sedang, sedang, rendah, rendah, rendah, rendah, rendah, rendah),
        listOf(sedang, sedang, sedang, rendah, rendah, rendah, rendah, rendah),
        listOf(sedang, sedang, sedang, sedang, rendah, rendah, rendah, rendah),
        listOf(tinggi, sedang, sedang, sedang, sedang, rendah, rendah, rendah),
        listOf(tinggi, tinggi, sedang, sedang, sedang, sedang, rendah, rendah),
        listOf(tinggi, tinggi, tinggi, sedang, sedang, sedang, sedang, rendah),
        listOf(tinggi, tinggi, tinggi, tinggi, sedang, sedang, sedang, sedang),
        listOf(tinggi, tinggi, tinggi, tinggi, tinggi, sedang, sedang, sedang)
    )

    fun hitung(berat: Int, umur: Int): Level {
        var a = 0
        var b = 0
        if (berat <= 44) {
            a = 0
        } else if (berat <= 49) {
            a = 1
        } else if (berat <= 54) {
            a = 2
        } else if (berat <= 59) {
            a = 3
        } else if (berat <= 64) {
            a = 4
        } else if (berat <= 69) {
            a = 5
        } else if (berat <= 74) {
            a = 6
        } else {
            a = 7
        }

        if (umur < 45) {
            return rendah
        } else if (umur <= 49) {
            b = 0
        } else if (umur <= 54) {
            b = 1
        } else if (umur <= 59) {
            b = 2
        } else if (umur <= 64) {
            b = 3
        } else if (umur <= 69) {
            b = 4
        } else if (umur <= 74) {
            b = 5
        } else if (umur <= 79) {
            b = 6
        } else if (umur <= 84) {
            b = 7
        }else {
            b = 8
        }
        return table[b][a]
    }
}