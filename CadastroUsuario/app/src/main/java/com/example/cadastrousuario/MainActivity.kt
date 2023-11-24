package com.example.cadastrousuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

 private lateinit var Cadastro: Button
 private lateinit var btnLogin: Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Cadastro = findViewById(R.id.Cadastro)
        btnLogin = findViewById(R.id.btnLogin)

        Cadastro.setOnClickListener{
            val intent = Intent(this, cadastro_user::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener{
            val Intent = Intent(this, login_user::class.java)
            startActivity(Intent)
        }

        }



    }
