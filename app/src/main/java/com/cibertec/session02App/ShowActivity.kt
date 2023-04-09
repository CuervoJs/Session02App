package com.cibertec.session02App

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        //OBTENER BUNDLE
        val bundle = intent.extras

        val names = bundle!!.getString("KEY_NAME")
        val age = bundle!!.getString("KEY_AGE")
        val genre = bundle!!.getString("KEY_GENRE")
        /*
        val msj : String = "Nombres : $names - Edad: $age - Género: $genre"
        val dialog = AlertDialog.Builder(this)

        dialog.setTitle("Information")
        dialog.setMessage(msj)
        dialog.show()
        */
    }
}