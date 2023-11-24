package com.example.cadastrousuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

 private lateinit var btnCadastro: Button
 private lateinit var btnLogin: Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCadastro = findViewById(R.id.btnCadastro)
        btnLogin = findViewById(R.id.btnLogin)

        btnCadastro.setOnClickListener{
            val Intent = Intent(this, cadastro_user::class.java)
            startActivity(Intent)
        }
        //btnLogin.setOnClickListener{
        //    val intent = Intent(this, cada::class.java)
         //   startActivity(Intent)
        //}

        }



    }
