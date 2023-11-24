package com.example.cadastrousuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login_user : AppCompatActivity() {

    private lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_user)
    }
}