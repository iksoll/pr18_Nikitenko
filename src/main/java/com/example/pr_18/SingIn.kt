package com.example.pr_18

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class SingIn : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var password: EditText
    private lateinit var pref: SharedPreferences
    private lateinit var soxrlog: TextView
    private lateinit var soxrpass: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        soxrlog = findViewById(R.id.soxrlog);
        soxrpass= findViewById(R.id.soxrpass);
    }
    fun coxr(v: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Выбор действия")
            .setMessage("Выберите действие.")
            .setCancelable(true)

            .setPositiveButton(getString(R.string.soxr)) { _, _ ->
                pref = getPreferences(MODE_PRIVATE)
                val ed = pref.edit()
                ed.putString(getString(R.string.login), login.text.toString())
                ed.putString(getString(R.string.password), password.text.toString())
                ed.apply()

                soxrlog.text = (pref.getString(getString(R.string.login), ""))
                soxrpass.text = (pref.getString(getString(R.string.password), ""))

                val alert = AlertDialog.Builder(this)
                    .setTitle(getString(R.string.ysp))
                    .setMessage("Введенные данные сохранены.")
                    .setPositiveButton(getString(R.string.prodol),null)
                    .create()
                    .show()
            }

            .setNegativeButton("Загрузить") { _,_ ->
                pref=getPreferences(MODE_PRIVATE)
                login.setText(pref.getString(getString(R.string.login),""))
                password.setText(pref.getString(getString(R.string.password),""))
                val alert = AlertDialog.Builder(this)
                    .setTitle(getString(R.string.ysp))
                    .setMessage("Сохранненые данные загружены.")
                    .setPositiveButton(getString(R.string.prodol),null)
                    .create()
                    .show()
            }
        builder.create()
        builder.show()

    }

    fun next(view: View) {
        if (login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
        {
            val intent = Intent(this,SplashFilm::class.java)
            startActivity(intent)
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите логин или пароль")
                .setPositiveButton(getString(R.string.prodol),null)
                .create()
                .show()

        }


    }
}