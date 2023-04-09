package com.cibertec.session02App

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend : Button = findViewById(R.id.btnSend)
        val edtNames : TextInputEditText = findViewById(R.id.edtNames)
        val edtAge : TextInputEditText = findViewById(R.id.edtAge)
        val rdMale : RadioButton = findViewById(R.id.rdbtnMale)
        val chkTerms : CheckBox = findViewById(R.id.chkTerms)

        btnSend.setOnClickListener{

            val names = edtNames.text.toString()
            val age = edtAge.text.toString()
            val genre:String = if(rdMale.isChecked) "Masculino" else "Femenino"

            //VALIDAR

            if(names.isEmpty()){
                Toast.makeText(this, getString(R.string.activity_main_valid_names), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(age.isEmpty()){
                Toast.makeText(this, getString(R.string.activity_main_valid_age), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(!chkTerms.isChecked) {
                Toast.makeText(this, getString(R.string.activity_main_valid_terms), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //NAVEGA ENTRE VENTANAS
            val bundle = Bundle().apply {
                putString("KEY_NAME",names)
                putString("KEY_AGE",age)
                putString("KEY_GENRE",genre)
            }

            /*
            bundle.putString("KEY_NAME",names)
            bundle.putString("KEY_AGE",age)
            bundle.putString("KEY_GENRE",genre)
            */

            val intent = Intent(this, ShowActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        /*
            //PARA LANZAR MSJ

            val dialog = AlertDialog.Builder(this)
            val names = edtNames.text.toString()
            val age = edtAge.text.toString()
            var genre:String = ""
            var terms:String = ""

            if(rdMale.isChecked) genre = rdMale.text.toString()
            else if(rdFemale.isChecked) genre = rdFemale.text.toString()
            if(chkTerms.isChecked) terms = "Si"

            val sb = java.lang.StringBuilder()

            sb.appendLine("Nombres: $names")
              .appendLine("Edad: $age")
              .appendLine("Genero: $genre")
              .appendLine("Acepto terminos? $terms")

            val msj = sb.toString()

            dialog.setTitle("Information")
            dialog.setMessage(msj)
            dialog.show()
        */

        }

    }
}
