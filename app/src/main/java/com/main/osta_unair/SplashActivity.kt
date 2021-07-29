package com.main.osta_unair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Handler().postDelayed(object: Runnable {
            override fun run() {
                val main = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(main)
                finish()
            }
        }, 4000)
    }
}