package com.main.osta_unair.ui.news

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.main.osta_unair.databinding.ComponentCardNewsBinding
import com.main.osta_unair.model.Tips
import com.main.osta_unair.data.News as DataNews

class NewsAdapter(private val context: Context, private val res: Resources, val showBottomDialog: (Tips) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val n: DataNews = DataNews()
    private val listNews: List<Tips> = n.listNews

    inner class ViewHolder(private val binding: ComponentCardNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Tips) {
            binding.tvNewsTitle.text = res.getString(item.title)
            binding.tvNewsShort.text = n.getShort(res, item.paragraph)

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