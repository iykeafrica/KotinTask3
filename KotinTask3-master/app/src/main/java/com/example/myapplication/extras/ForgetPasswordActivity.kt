package com.example.myapplication.extras

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.LoginRegisterActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_forget_password.*


class ForgetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        btn_back_to_login.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@ForgetPasswordActivity,
                    LoginRegisterActivity::class.java
                )
            )
        })
    }
}
