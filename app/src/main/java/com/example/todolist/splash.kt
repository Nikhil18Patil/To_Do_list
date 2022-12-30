package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
val time:Long= 5000
        Handler().postDelayed({
            val inter = Intent(splash@this, MainActivity::class.java)
            startActivity(inter)
        },time )

    }
}