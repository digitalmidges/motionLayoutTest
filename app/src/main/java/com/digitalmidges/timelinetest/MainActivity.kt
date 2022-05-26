package com.digitalmidges.timelinetest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.digitalmidges.timelinetest.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private var weatherAdapter: TimelineWeatherAdapter?=null
    private var timelineAdapter: TimelineAdapter?=null

    private val weatherRecyclerView:RecyclerView
        get() = binding.weatherRecyclerView

    private val weatherRecyclerViewWrapper: ViewGroup
        get() = binding.recyclerViewWeatherWrapper

    private val timelineRecyclerView:RecyclerView
        get() = binding.recyclerViewTimeLine

    private val isWeatherRecyclerViewVisible:Boolean
        get()= weatherRecyclerViewWrapper.isVisible

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setStatusBarTransparentColorWithWhiteText()

        weatherRecyclerViewWrapper.visibility = View.GONE
        weatherRecyclerView.visibility = View.VISIBLE

        initWeatherRecyclerView()
        initRecyclerViewTimeline()
        initFakeCountDown()

        binding.weatherContent.setOnClickListener {
            showOrHideWeatherRecyclerView()
        }

    }

    private fun initFakeCountDown() {
        val countDownItem = CountDownItem(days = 10.toString(), hours = 3.toString(), minutes = 27.toString())
        binding.countDownView.setDataFromItem(countDownItem)
    }


    private fun setStatusBarTransparentColorWithWhiteText() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = ContextCompat.getColor(this, R.color.transparent)
        WindowInsetsControllerCompat(window, window.decorView.findViewById(android.R.id.content)).isAppearanceLightStatusBars = false
    }


    private fun initWeatherRecyclerView() {
        val weatherList = arrayListOf<WeatherItem>()
        var item = WeatherItem(temperature= "30",date = Date(), formatDate = "20 FEB", formatDateDayOfWeek="Tue",weatherImage="hey")
        weatherList.add(item)
        item = WeatherItem(temperature= "28",date = Date(), formatDate = "21 FEB", formatDateDayOfWeek="Tue",weatherImage="hey")
        weatherList.add(item)
        item = WeatherItem(temperature= "22",date = Date(), formatDate = "22 FEB", formatDateDayOfWeek="Tue",weatherImage="hey")
        weatherList.add(item)
        item = WeatherItem(temperature= "26",date = Date(), formatDate = "23 FEB", formatDateDayOfWeek="Tue",weatherImage="hey")
        weatherList.add(item)
        item = WeatherItem(temperature= "33",date = Date(), formatDate = "24 FEB", formatDateDayOfWeek="Tue",weatherImage="hey")
        weatherList.add(item)
        item = WeatherItem(temperature= "36",date = Date(), formatDate = "25 FEB", formatDateDayOfWeek="Tue",weatherImage="hey")
        weatherList.add(item)
        item = WeatherItem(temperature= "31",date = Date(), formatDate = "26 FEB", formatDateDayOfWeek="Tue",weatherImage="hey")
        weatherList.add(item)
        val linearLayoutManager = LinearLayoutManager(this.applicationContext, RecyclerView.HORIZONTAL,false)
        weatherRecyclerView.layoutManager = linearLayoutManager
        weatherAdapter = TimelineWeatherAdapter(weatherList)
        weatherRecyclerView.adapter = weatherAdapter
    }


    private fun initRecyclerViewTimeline() {
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        timelineRecyclerView.layoutManager = linearLayoutManager
        timelineAdapter = TimelineAdapter()
        timelineRecyclerView.adapter = timelineAdapter

    }




    private fun showOrHideWeatherRecyclerView() {

        var visiblyState = View.VISIBLE
        val transition: Transition = if(isWeatherRecyclerViewVisible){
            visiblyState = View.VISIBLE
            weatherLayoutCollapseTransition()
        }else{
            weatherLayoutExpandTransition()
        }
//        var transition: Transition = slideFromBottomTransition()
        TransitionManager.beginDelayedTransition(binding.root, transition)
        weatherRecyclerViewWrapper.visibility = visiblyState
        weatherRecyclerView.scrollToPosition(0)

//        onSwitchButtonClicked()

    }

    private fun weatherLayoutExpandTransition(): Transition {
        val transition = AutoTransition()
        transition.interpolator = AccelerateDecelerateInterpolator()
        transition.duration = 400
        transition.addTarget(weatherRecyclerViewWrapper)
        transition.addListener(object : Transition.TransitionListener {
            override fun onTransitionEnd(transition: Transition) {
            }

            override fun onTransitionResume(transition: Transition) {
            }

            override fun onTransitionPause(transition: Transition) {
            }

            override fun onTransitionCancel(transition: Transition) {
            }

            override fun onTransitionStart(transition: Transition) {
            }

        })
        return transition
    }



    private fun weatherLayoutCollapseTransition(): Transition {
        val transition: Transition = AutoTransition()
        transition.duration = 5000
        transition.addTarget(weatherRecyclerViewWrapper)
        transition.addListener(object : Transition.TransitionListener {
            override fun onTransitionEnd(transition: Transition) {
                weatherRecyclerViewWrapper.visibility = View.GONE
            }

            override fun onTransitionResume(transition: Transition) {
            }

            override fun onTransitionPause(transition: Transition) {
            }

            override fun onTransitionCancel(transition: Transition) {
            }

            override fun onTransitionStart(transition: Transition) {
            }

        })
        return transition
    }

}