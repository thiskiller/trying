package com.ocean.trying.touchevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ocean.trying.R
import com.ocean.trying.databinding.ActivityTouchEventBinding

class TouchEventActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityTouchEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTouchEventBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}