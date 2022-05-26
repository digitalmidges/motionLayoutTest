package com.digitalmidges.timelinetest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digitalmidges.timelinetest.databinding.RowTimelineForYouBinding

/**
 * Created with care by odedfunt on 24/05/2022.
 */
class TimelineAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = RowTimelineForYouBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuChildItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is MenuChildItemViewHolder ->{
                holder.bind()
            }
        }
    }

    override fun getItemCount(): Int {
        return 100
    }




    // ============================================================================= //


    inner class MenuChildItemViewHolder(
            val binding: RowTimelineForYouBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind() {

//
//            binding.apply {
//                tvWeatherDegrees.text = item.degrees
//                tvWeatherDate.text = item.formatDate
//                tvWeatherDateDayOfWeek.text = item.formatDateDayOfWeek
//            }

        }
    }


    // ============================================================================= //
}