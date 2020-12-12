package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    //private val myEmail: MyEmail = MyEmail("yan.billy.20@gmail.com")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

    }
}
