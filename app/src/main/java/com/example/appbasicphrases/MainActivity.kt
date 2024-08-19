package com.example.appbasicphrases

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        clickListener()
    }

    private fun clickListener() {
        val imageAndroid = findViewById<ImageView>(R.id.ivAndroid)
        val imageDart = findViewById<ImageView>(R.id.ivDart)

        imageAndroid.setOnClickListener {
            openAndroidActivity()
        }

        imageDart.setOnClickListener {
            openDartActivity()
        }
    }

    private fun openAndroidActivity() {
        startActivity(
            Intent(this@MainActivity, AndroidActivity::class.java).putExtra(
                "name",
                "Android"
            ).putExtra("imageName", R.drawable.android)
        )
    }

    private fun openDartActivity() {
        startActivity(
            Intent(this@MainActivity, DartActivity::class.java).putExtra("name", "Dart")
                .putExtra("imageName", R.drawable.dart)
        )
    }
}