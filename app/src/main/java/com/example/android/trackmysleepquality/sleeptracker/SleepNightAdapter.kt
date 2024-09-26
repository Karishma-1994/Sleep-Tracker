package com.example.android.trackmysleepquality.sleeptracker


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding


class SleepNightAdapter(val clickListener:SleepNightListener):ListAdapter<SleepNight, SleepNightAdapter.SleepNightViewHolder>(SleepNightDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepNightViewHolder {

        val binding: ListItemSleepNightBinding =
            ListItemSleepNightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SleepNightViewHolder(binding)
    }



    override fun onBindViewHolder(holder: SleepNightViewHolder, position: Int) {
        holder.bind(getItem(position)!!,clickListener)
    }

    inner class SleepNightViewHolder(private val binding: ListItemSleepNightBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(sleepNight: SleepNight, clickListener: SleepNightListener) {

                binding.sleep = sleepNight
                binding.clickListner = clickListener
                binding.executePendingBindings()
        }


    }
    class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {
        override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
            return oldItem.nightId == newItem.nightId
        }

        override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
           return oldItem == newItem
        }
    }
}
class SleepNightListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(night: SleepNight) = clickListener(night.nightId)
}