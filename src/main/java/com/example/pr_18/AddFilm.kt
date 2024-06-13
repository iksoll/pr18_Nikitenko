package com.example.pr_18

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class AddFilm : AppCompatActivity() {
    private lateinit var knop1 : RadioButton
    private lateinit var knop2 : RadioButton
    private lateinit var knop3 : RadioButton
    private lateinit var knop4 : RadioButton
    private lateinit var knop5 : RadioButton
    lateinit var vibor: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_film)
        knop1 = findViewById(R.id.marvel)
        knop2 = findViewById(R.id.payk)
        knop3 = findViewById(R.id.golov)
        knop4 = findViewById(R.id.drakon)
        knop5 = findViewById(R.id.bog)
        vibor = findViewById<EditText>(R.id.messed)
    }
    fun a(view: View) {
        val selectValue = when{
            knop1.isChecked -> 1
            knop2.isChecked -> 2
            knop3.isChecked -> 3
            knop4.isChecked -> 4
            knop5.isChecked -> 5
            else -> 0
        }
        val mess = vibor.text.toString()
        if (selectValue === 0 || mess=="")
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Вы не указали, какой фильм вам понравился или не оставили комментарий!")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
        else {
            val mess = vibor.text.toString()
            val m = Film(mess, selectValue)
            val json = Gson().toJson(m).toString()
            val intent = Intent(this, ResultShow::class.java)
            intent.putExtra("mess", json)
            intent.putExtra("selectValue", selectValue)
            startActivity(intent)
        }
    }
}