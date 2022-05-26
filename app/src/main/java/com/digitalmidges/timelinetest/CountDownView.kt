package com.digitalmidges.timelinetest

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.digitalmidges.timelinetest.databinding.LayoutCountDownViewBinding

/**
 * Created with care by odedfunt on 24/05/2022.
 */
class CountDownView @JvmOverloads constructor(context: Context,
        attrs: AttributeSet? = null) : FrameLayout(context, attrs) {


    private var binding: LayoutCountDownViewBinding

    private val whiteColor: Int
        get() = ContextCompat.getColor(context, R.color.white)

    private val topazColor: Int
        get() = ContextCompat.getColor(context, R.color.topaz)

    companion object {
    }


    init {
        val factory = LayoutInflater.from(context)
        binding = LayoutCountDownViewBinding.inflate(factory)
        addView(binding.root)

        initAttribute(context, attrs)
        initView()

    }


    private fun initAttribute(context: Context, attrs: AttributeSet?) {

        if (attrs != null) {
//            val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomEditText, 0, 0)
//            typedArray.recycle()
        }

    }


    private fun initView() {
    }

    fun setDataFromItem(countDownItem: CountDownItem) {
        binding.apply {
            tvCountDownDays.text = countDownItem.days
            tvCountDownHours.text = countDownItem.hours
            tvCountDownMinutes.text = countDownItem.minutes
        }
    }


}