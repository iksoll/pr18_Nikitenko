package com.example.pr_18

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog

class SplashFilm : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_film)
        val spinner = findViewById<Spinner>(R.id.spinner)
        var selecte = spinner.selectedItemPosition
        pref = getPreferences(MODE_PRIVATE)
        if (pref.getInt("spinner", 0) != 0) {
            selecte= pref.getInt("spinner", 0)
        }
        f(selecte)
    }
    fun spin(v: View) {
        val spinner = findViewById<Spinner>(R.id.spinner)
        val selecte = spinner.selectedItemPosition
        pref = getPreferences(MODE_PRIVATE)
        val ed = pref.edit()
        ed.putInt("spinner", selecte)
        ed.apply()
        f(selecte)

    }

    private fun f(selecte: Int) {
        imageView = findViewById<ImageView>(R.id.imageView)
        var image: Int
        when (selecte) {
            0 -> {
                image = R.drawable.marvel
            }

            1 -> {
                image = R.drawable.pa
            }

            2 -> {
                image = R.drawable.golovolomka
            }
            3 -> {
                image = R.drawable.dracon
            }
            4 -> {
                image = R.drawable.bog
            }

            else -> image = 0
        }

        imageView.setImageResource(image)

    }
    fun next(view: View) {

            val intent = Intent(this,AddFilm::class.java)
            startActivity(intent)

    }

}