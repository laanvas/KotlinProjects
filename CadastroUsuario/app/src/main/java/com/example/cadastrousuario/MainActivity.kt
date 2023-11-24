package com.example.cadastrousuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


   private lateinit var nome: EditText
   private lateinit var cpf: EditText
   private lateinit var email: EditText
   private lateinit var senha: EditText
   private lateinit var enviar: Button
   private lateinit var c: Connection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nome = findViewById(R.id.nome)
        cpf = findViewById(R.id.cpf)
        email = findViewById(R.id.email)
        senha = findViewById(R.id.senha)
        enviar = findViewById(R.id.enviar)
        c = Connection(this)

        enviar.setOnClickListener{
            val nometext = nome.text.toString()
            val cpftext = cpf.text.toString()
            val emailtext = email.text.toString()
            val senhatext = senha.text.toString()
            //armazena estes dados
            val savedata = c.insertValues(nometext,cpftext,emailtext,senhatext)

            if(TextUtils.isEmpty(nometext) || TextUtils.isEmpty(cpftext) || TextUtils.isEmpty(emailtext) || TextUtils.isEmpty(senhatext) ){
                Toast.makeText(this, "Preencha todos os campos corretamente!!", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Cadastro feito com sucesso!!", Toast.LENGTH_SHORT).show()
            }


        }



    }
}