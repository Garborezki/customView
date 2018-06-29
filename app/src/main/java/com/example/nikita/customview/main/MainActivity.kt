package com.example.nikita.customview.main

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nikita.customview.R
import com.example.nikita.customview.presentetion.mainScreen.MainScreenFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, MainScreenFragment())
                .commit()
    }
}
