package com.example.hanium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        signInBtn.setOnClickListener {
            var email:String? = null
            var passWord:String? = null
            email = loginEmail.text.toString()
            passWord = loginPassword.text.toString()

            Log.d("login","login btn click")

        }
    }
}
