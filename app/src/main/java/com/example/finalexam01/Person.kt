package com.example.finalexam01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class Person: AppCompatActivity() {



    private lateinit var mAuth: FirebaseAuth
    private lateinit var id_txt: TextView
    private lateinit var id_name: TextView
    private lateinit var id_email: TextView
    private lateinit var imageview: ImageView
    private lateinit var gamosvla: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        mAuth= FirebaseAuth.getInstance()


        val currentuser = mAuth.currentUser
        id_txt = findViewById(R.id.id_txt)
        id_name = findViewById(R.id.id_name)
        id_email= findViewById(R.id.id_email)
        imageview = findViewById(R.id.imageview)
        gamosvla = findViewById(R.id.gamosvla)



        id_txt.text = currentuser?.uid
        id_email.text = currentuser?.email
        id_name.text = currentuser?.displayName

        Glide.with(this)
            .load(currentuser?.photoUrl)
            .circleCrop()
            .into(imageview)
        gamosvla.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()

            mAuth.signOut()
        }



    }
}