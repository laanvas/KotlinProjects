package com.example.cadastrousuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login_user : AppCompatActivity() {

    private lateinit var login: Button
    private lateinit var email: EditText
    private lateinit var senha: EditText
    private lateinit var con: Connection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_user)

        login = findViewById(R.id.login)
        email = findViewById(R.id.login_email)
        senha = findViewById(R.id.login_senha)
        con = Connection(this)

        login.setOnClickListener{
            val login_email = email.text.toString()
            val login_senha = senha.text.toString()

        if(TextUtils.isEmpty(login_email) || TextUtils.isEmpty(login_senha)){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }else{
            val checkacess = con.checkentry(login_email, login_senha)
            if(checkacess == true){
                val Intent = Intent(this, sucessacess::class.java)
                startActivity(Intent)
            }else{
                Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }

        }

        }

    }
}