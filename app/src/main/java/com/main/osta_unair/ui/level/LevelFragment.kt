package com.main.osta_unair.ui.level

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.main.osta_unair.databinding.FragmentLevelBinding
import com.main.osta_unair.model.Level

class LevelFragment(private val ctx: Context, val showDialog: (Level) -> Unit) : Fragment() {

    private lateinit var levelBinding: FragmentLevelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = LevelAdapter(ctx, resources) { level -> showDialog(level) }

        levelBinding = FragmentLevelBinding.inflate(inflater, container, false)
        levelBinding.rvLevel.layoutManager = LinearLayoutManager(ctx)
        levelBinding.rvLevel.adapter = adapter

        return levelBinding.root
    }

}