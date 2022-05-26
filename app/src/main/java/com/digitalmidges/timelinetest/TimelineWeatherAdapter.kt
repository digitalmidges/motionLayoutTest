package com.digitalmidges.timelinetest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digitalmidges.timelinetest.databinding.RowTimelineWeatherBinding

/**
 * Created with care by odedfunt on 24/05/2022.
 */
class TimelineWeatherAdapter(var weatherItemsList: ArrayList<WeatherItem>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private fun getItem(position: Int): WeatherItem? {
        if (weatherItemsList.isNullOrEmpty()) {
            return null
        }
        return if (position < weatherItemsList!!.size) {
            weatherItemsList!![position]
        } else {
            return null
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

//        val binding = RowTimelineWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val binding = RowTimelineWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is WeatherItemViewHolder ->{
                holder.bind(getItem(position))
            }
        }
    }

    override fun getItemCount(): Int {
        if (!weatherItemsList.isNullOrEmpty()) {
            return weatherItemsList!!.size
        }
        return 0
    }

    fun updateData(childList: ArrayList<WeatherItem>?) {
        this.weatherItemsList = childList
        notifyDataSetChanged()
    }



    // ============================================================================= //


    inner class WeatherItemViewHolder(
            val binding: RowTimelineWeatherBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: WeatherItem?) {

            if (item == null) {
                return
            }

            binding.apply {
                binding.imgWeatherIcon.visibility = View.INVISIBLE
                tvWeatherTemperature.text = item.temperature
                tvWeatherDate.text = item.formatDate
                tvWeatherDateDayOfWeek.text = item.formatDateDayOfWeek
                binding.imgWeatherIcon.visibility = View.VISIBLE
            }

        }
    }


    // ============================================================================= //
}