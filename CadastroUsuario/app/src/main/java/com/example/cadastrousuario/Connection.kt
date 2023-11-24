package com.example.cadastrousuario

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.DriverManager
import java.sql.SQLException


class Connection(context: Context):SQLiteOpenHelper(context, "Userdate", null, 1) {
    override fun onCreate(c: SQLiteDatabase?) {
        //aqui que vai ser criada a tabela de usuario
        c?.execSQL("CREATE TABLE Userdate (nome VARCHAR(255) NOT NULL,\n" +
                "    cpf VARCHAR(11) NOT NULL,\n" +
                "    email VARCHAR(255) NOT NULL,\n" +
                "    senha VARCHAR(255) NOT NULL)")
    }

    override fun onUpgrade(c: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        c?.execSQL("DROP TABLE IF EXISTS Userdate")

    }

    fun insertValues(nome: String , cpf: String, email: String, senha: String): Boolean{
        val c = this.writableDatabase
        val cv = ContentValues()
        cv.put("nome",nome)
        cv.put("cpf",cpf)
        cv.put("email",email)
        cv.put("senha",senha)
            val result = c.insert("Userdate", null, cv)
            if(result == -1 .toLong()){
                return false
            }
        return true
    }

    fun showValues(nome: String, cpf: String, email: String, senha: String): Boolean{
        val c = this.writableDatabase
        val query = "Select * From Userdate"
        val cursor = c.rawQuery(query, null)

        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true

    }

}