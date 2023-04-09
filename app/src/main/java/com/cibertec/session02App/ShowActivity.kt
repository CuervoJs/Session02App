package com.cibertec.session02App

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val lblName : TextView = findViewById(R.id.lblName)
        val lblAge : TextView = findViewById(R.id.lblAge)
        val lblGenre : TextView = findViewById(R.id.lblGenre)
        //val btnShow : Button = findViewById(R.id.btnShow)

        //OBTENER BUNDLE
        val bundle = intent.extras

        //btnShow.setOnClickListener{btn ->
            bundle?.let { bdl ->
                val names = bdl.getString("KEY_NAME")
                val age = bdl.getString("KEY_AGE")
                val genre = bdl.getString("KEY_GENRE")

                lblName.text = names
                lblAge.text = age
                lblGenre.text = genre

            } ?: kotlin.run {
                Toast.makeText(this, "Valores desconocidos en ShowActivity", Toast.LENGTH_LONG).show()
            }
        //}


        // String!! es para aceptar nulos
        // String? es para no permitir nulos

        /*
        val names = bundle!!.getString("KEY_NAME")
        val age = bundle!!.getString("KEY_AGE")
        val genre = bundle!!.getString("KEY_GENRE")
        */



        /*
        val msj : String = "Nombres : $names - Edad: $age - Género: $genre"
        val dialog = AlertDialog.Builder(this)

        dialog.setTitle("Information")
        dialog.setMessage(msj)
        dialog.show()
        */
    }
}