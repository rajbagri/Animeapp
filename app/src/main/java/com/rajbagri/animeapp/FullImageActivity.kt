package com.rajbagri.animeapp

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import java.io.IOException

class FullImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)

        val imageUrl = intent.getStringExtra("image_url")

        val setWallpaperButtonHome = findViewById<Button>(R.id.setWallpaperButtonHome)
        setWallpaperButtonHome.setOnClickListener { setWallpaperHome() }

        val setWallpaperButtonLock = findViewById<Button>(R.id.setWallpaperButtonLock)
        setWallpaperButtonLock.setOnClickListener { setWallpaperLock() }

        val fullImageView: ImageView = findViewById(R.id.full_image_view)
        Picasso.get()
            .load(imageUrl)
            .into(fullImageView)
    }



    private fun setWallpaperHome() {
        val fullImageView: ImageView = findViewById(R.id.full_image_view)
        val bitmap = (fullImageView.drawable as BitmapDrawable).bitmap

        val newWidth = 1080 // Set the desired width
        val newHeight = 1920 // Set the desired height

        val resizedBitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)

        val wallpaperManager = WallpaperManager.getInstance(this)
        try {
            wallpaperManager.setBitmap(resizedBitmap, null, true, WallpaperManager.FLAG_SYSTEM)


        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun setWallpaperLock() {
        val fullImageView: ImageView = findViewById(R.id.full_image_view)
        val bitmap = (fullImageView.drawable as BitmapDrawable).bitmap

        val newWidth = 1080 // Set the desired width
        val newHeight = 1920 // Set the desired height

        val resizedBitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)

        val wallpaperManager = WallpaperManager.getInstance(this)
        try {

            // Set the wallpaper for the lock screen
            wallpaperManager.setBitmap(resizedBitmap, null, true, WallpaperManager.FLAG_LOCK)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}

