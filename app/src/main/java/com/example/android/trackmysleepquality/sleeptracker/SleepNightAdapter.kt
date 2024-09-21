package com.example.android.trackmysleepquality.sleeptracker


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.TextItemViewBinding


class SleepNightAdapter : RecyclerView.Adapter<SleepNightAdapter.SleepNightViewHolder>() {
    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepNightViewHolder {
        val binding: TextItemViewBinding =
            TextItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SleepNightViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SleepNightViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class SleepNightViewHolder(private val binding: TextItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sleepNight: SleepNight) {
            binding.tvText.text = sleepNight.sleepQuality.toString()
            if (sleepNight.sleepQuality <= 1) {
                binding.tvText.setTextColor(Color.RED)
            } else {
                binding.tvText.setTextColor(Color.BLACK)
            }
        }
    }
}
