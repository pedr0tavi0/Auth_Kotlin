package com.example.a10052024

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance()
        val loginBotao = findViewById<Button>(R.id.botao1)
        loginBotao.setOnClickListener {

            val email = findViewById<EditText>(R.id.email).text.toString()
            val senha = findViewById<EditText>(R.id.senha).text.toString()

            loginUser(email, senha)

        }





    }




    private fun loginUser(email: String, senha: String){

        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this) {
            task ->

            if (task.isSuccessful){
                Toast.makeText(this, "Login Feito Com Sucesso", Toast.LENGTH_SHORT).show()


            }else{

                Toast.makeText(this,"Login Sem Sucesso: ${task.exception?.message}",Toast.LENGTH_SHORT).show()
            }


        }



    }



}