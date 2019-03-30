package com.example.trainer.materianko

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class Register : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnregsiter.setOnClickListener {
            val fullName = fullname.text.toString().trim()
            val username = usernamereg.text.toString().trim()
            val password = passwordreg.text.toString().trim()
            handleOnRegister(fullName = fullName, username = username, password = password)

        }
    }

    private fun handleOnRegister(fullName: String, username: String, password: String) {
        info { "fullName : $fullName & username : $username & password : $password"  }
        when {
            fullName.isEmpty() -> toast("FullName is Required")
            username.isEmpty() -> toast("Username is Required")
            password.isEmpty() -> toast("Password is Required")
            else -> alert(title =  "Register", message = "Your Account has been Created"){
                positiveButton("OK"){
                    onBackPressed()
                }
                isCancelable = false
            }.show()
        }

    }
}