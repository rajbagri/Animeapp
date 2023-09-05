package com.rajbagri.animeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.os.postDelayed
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)


        val SPLASH_DELAY: Long = 3000
        imageView = findViewById(R.id.splash_image)

        val intent = Intent(this@SplashActivity, MainActivity::class.java)

        Picasso.get()
            .load("https://w0.peakpx.com/wallpaper/259/887/HD-wallpaper-solo-leveling-anime-black-blue-boy-dark-manga-manhwa-solo-leveling-top.jpg")
            .into(imageView)


        Handler(Looper.getMainLooper()).postDelayed(3000){
            startActivity(intent)
            finish()
        }
    }
}