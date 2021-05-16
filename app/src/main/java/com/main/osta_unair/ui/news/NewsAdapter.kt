package com.main.osta_unair.ui.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.main.osta_unair.databinding.ComponentCardNewsBinding

class NewsAdapter(private val context: Context, val showBottomDialog: (News) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val listNews: List<News> = listOf(
        News(
            "Title1",
            "Short Descriptiion 1",
            "Long Description is here boyyiiii",
            null
        ),
        News(
            "Meningkatkan kualitas tulang",
            "Tulang adalah penting pokoknya",
            "Tulans Hanya bla bla bla karena bla bla bla",
            null
        )
    )

    inner class ViewHolder(private val binding: ComponentCardNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: News) {
            binding.tvNewsTitle.text = item.title
            binding.tvNewsShort.text = item.short

            binding.rootNews.setOnClickListener {
                showBottomDialog(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ComponentCardNewsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNews[position])
    }

    override fun getItemCount(): Int = listNews.size
}