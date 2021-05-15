package com.main.osta_unair.ui.level

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.main.osta_unair.MainActivity
import com.main.osta_unair.R
import com.main.osta_unair.databinding.ComponentCardLevelBinding

class LevelAdapter(private val context: Context, val showBottomDialog: (Level) -> Unit) :
    RecyclerView.Adapter<LevelAdapter.ViewHolder>() {

    private val listLevel: List<Level> = listOf(
        Level(
            "Low",
            "Short Description",
            "Long Description is this amazing cool sentences",
            ContextCompat.getColor(context, R.color.blue_200)
        ),
        Level(
            "Medium",
            "Short Medium Description",
            "Long Medium Description terlalu beresiko untuk anda",
            ContextCompat.getColor(context, R.color.blue_500)
        ),
        Level(
            "DANGER",
            "Short DANGERR Description",
            "Long DANGER DEscription pali b berhabata asjdka asd ",
            ContextCompat.getColor(context, R.color.blue_200)
        )
    )

    inner class ViewHolder(private val binding: ComponentCardLevelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Level) {
            binding.rootLinearLayout.setBackgroundColor(item.color)
            binding.cardTitle.text = item.title
            binding.cardShort.text = item.short
            binding.rootLinearLayout.setOnClickListener {
                showBottomDialog(item)
                Log.d("LEVEL_ADAPTER","CLCIK item ${item.title}")
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