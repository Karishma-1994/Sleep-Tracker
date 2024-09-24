package com.example.android.trackmysleepquality.sleeptracker


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.alpha
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding
import com.example.android.trackmysleepquality.databinding.TextItemViewBinding


class SleepNightAdapter : RecyclerView.Adapter<SleepNightAdapter.SleepNightViewHolder>() {
    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepNightViewHolder {

        val binding: ListItemSleepNightBinding =
            ListItemSleepNightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SleepNightViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SleepNightViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class SleepNightViewHolder(private val binding: ListItemSleepNightBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(sleepNight: SleepNight) {
                binding.sleepLength.text = sleepNight.sleepQuality.toString()
                binding.qualityString.text = sleepNight.sleepQuality.toString()


                val res = itemView.context.resources

                binding.sleepLength.text = convertDurationToFormatted(
                    sleepNight.startTimeMilli, sleepNight.endTimeMilli, res
                )
                binding.qualityString.text = convertNumericQualityToString(sleepNight.sleepQuality, res)

                binding.qualityImage.setImageResource(when (sleepNight.sleepQuality) {
                    0 -> R.drawable.ic_sleep_0
                    1 -> R.drawable.ic_sleep_1
                    2 -> R.drawable.ic_sleep_2
                    3 -> R.drawable.ic_sleep_3
                    4 -> R.drawable.ic_sleep_4
                    5 -> R.drawable.ic_sleep_5
                    else -> R.drawable.ic_sleep_active
                })
        }


    }
}
