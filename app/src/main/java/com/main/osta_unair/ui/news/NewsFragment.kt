package com.main.osta_unair.ui.news

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.main.osta_unair.databinding.FragmentNewsBinding
import com.main.osta_unair.model.Tips


class NewsFragment(private val ctx: Context, val showDialog: (Tips) -> Unit) : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)

        val adapter = NewsAdapter(ctx, resources) { tips -> showDialog(tips) }

        binding.rvNews.layoutManager = LinearLayoutManager(ctx)
        binding.rvNews.adapter = adapter
        return binding.root
    }

}