package com.main.osta_unair.ui.level

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.main.osta_unair.data.Risiko
import com.main.osta_unair.databinding.ComponentCardLevelBinding
import com.main.osta_unair.model.Level

class LevelAdapter(private val context: Context, val resources: Resources, val showBottomDialog: (Level) -> Unit) :
    RecyclerView.Adapter<LevelAdapter.ViewHolder>() {

    val r = Risiko()
    private val listLevel: List<Level> = r.listLevel

    @Suppress("DEPRECATION")
    inner class ViewHolder(private val binding: ComponentCardLevelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Level) {
            binding.cardTitle.setBackgroundColor(resources.getColor(item.color))
            binding.cardTitle.setPadding(10,3,10,3)
            binding.cardTitle.text = item.title
            binding.cardShort.text = resources.getString(item.short)
            binding.rootLinearLayout.setOnClickListener {
                showBottomDialog(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ComponentCardLevelBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listLevel[position])
    }

    override fun getItemCount(): Int = listLevel.size
}