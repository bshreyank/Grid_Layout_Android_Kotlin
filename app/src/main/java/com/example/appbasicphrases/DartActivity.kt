package com.example.appbasicphrases

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initData()
    }

    private fun initData(){
        val passedData = intent.extras

        var tvName = findViewById<TextView>(R.id.tvName)
        var imageView = findViewById<ImageView>(R.id.imageView)

        val name = passedData!!.getString("name")
        val imageName = passedData.getInt("imageName")

        tvName.setText(name)
        imageView.setImageResource(imageName)

    }

}