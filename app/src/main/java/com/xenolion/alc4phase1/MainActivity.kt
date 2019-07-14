package com.xenolion.alc4phase1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

// Created by Xenolion in 14 July 2019

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // When buttons are clicked move to another Activities
        btnAboutAlc.setOnClickListener { startActivity(Intent(this,AboutALCActivity::class.java)) }
        btnMyProfile.setOnClickListener { startActivity(Intent(this,MyProfileActivity::class.java)) }
    }
}
