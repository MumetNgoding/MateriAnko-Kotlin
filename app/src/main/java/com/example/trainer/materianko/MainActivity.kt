package com.example.trainer.materianko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val username = username.toString().trim()
            val password = password.toString().trim()
            handleLogin(username = username, password = password)
        }

        btn2.setOnClickListener {
            toast("Pindah Ke Halaman Register")
            startActivity(intentFor<Register>())
        }

    }

    private fun handleLogin(username: String, password: String) {
            info { "data username : $username, data password : $password" } //log.i jika ditulis di java
            if (username.equals("test") && password.equals("test123")) {
                toast("Welcome Aboard $username")

            } else {
                alert(title = "Warning", message = "Password atau Username Salah") {
                    positiveButton(buttonText = "OK") {
                        //
                    }

                    isCancelable = false
                }.show()
            }
    }
}