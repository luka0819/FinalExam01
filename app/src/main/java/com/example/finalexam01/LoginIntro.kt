package com.example.finalexam01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginIntro : AppCompatActivity() {
    private lateinit var txtLoginSubHeader: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)


        txtLoginSubHeader = findViewById(R.id.txtLoginSubHeader)

        txtLoginSubHeader.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}