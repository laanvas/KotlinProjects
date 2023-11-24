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
    private lateinit var c: Connection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_user)

        login = findViewById(R.id.login)
        email = findViewById(R.id.email)
        senha = findViewById(R.id.senha)
        c = Connection(this)

        login.setOnClickListener{
            val emailtext = email.text.toString()
            val senhatext = senha.text.toString()

        if(TextUtils.isEmpty(emailtext) || TextUtils.isEmpty(senhatext)){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }else{
            val checkemail = c.checkentry(emailtext, senhatext)
            if(checkemail == true){
                val intent = Intent(this, systemacess::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }

        }

        }

    }
}