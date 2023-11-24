package com.example.cadastrousuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private lateinit var nome: EditText
private lateinit var cpf: EditText
private lateinit var email: EditText
private lateinit var senha: EditText
private lateinit var enviar: Button
private lateinit var senha_confirm: EditText
private lateinit var c: Connection



class cadastro_user : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_user)

        nome = findViewById(R.id.cadastro_nome)
        cpf = findViewById(R.id.cadastro_cpf)
        email = findViewById(R.id.cadastro_email)
        senha = findViewById(R.id.cadastro_senha)
        senha_confirm = findViewById(R.id.confirm_senha)
        enviar = findViewById(R.id.enviar)
        c = Connection(this)

        enviar.setOnClickListener {
            val nometext = nome.text.toString()
            val cpftext = cpf.text.toString()
            val emailtext = email.text.toString()
            val senhatext = senha.text.toString()
            val senha_confirmtext = senha_confirm.text.toString()
            //armazena estes dados
            val savedata = c.insertValues(nometext, cpftext, emailtext, senhatext)

            if (TextUtils.isEmpty(nometext) || TextUtils.isEmpty(cpftext) || TextUtils.isEmpty(
                    emailtext
                ) || TextUtils.isEmpty(senhatext)
            ) {
                Toast.makeText(this, "Preencha todos os campos corretamente!!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if(senhatext.equals(senha_confirmtext)){
                    if(savedata == true){
                        Toast.makeText(this, "Cadastro feito com sucesso!!!", Toast.LENGTH_SHORT).show()
                        val Intent = Intent(applicationContext, login_user::class.java)
                        startActivity(Intent)
                    }else{
                        Toast.makeText(this, "Usuario já existente", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Senhas não combinam", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}