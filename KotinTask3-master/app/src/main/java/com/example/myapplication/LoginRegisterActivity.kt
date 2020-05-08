package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.dbhelper.DbHelper
import com.example.myapplication.extras.ForgetPasswordActivity
import com.example.myapplication.session.Session


class LoginRegisterActivity : AppCompatActivity(), View.OnClickListener {
    var etEmail: EditText? = null
    var etPassword: EditText? = null
    var textView: TextView? = null
    var tvForgetPassword: TextView? = null
    var tvSignUp: TextView? = null
    var btnLogin: Button? = null
    var btnSignUp: Button? = null
    var db: DbHelper? = null
    var session: Session? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvForgetPassword = findViewById(R.id.tv_forget_pass)
        tvSignUp = findViewById(R.id.tv_sign_up)
        textView = findViewById(R.id.textView)
        btnLogin = findViewById(R.id.btn_login)
        btnSignUp = findViewById(R.id.btn_nav_sign_up)
        db = DbHelper(this)
        session = Session(this)

        tvForgetPassword?.setOnClickListener(this)
        tvSignUp?.setOnClickListener(this)
        btnLogin?.setOnClickListener(this)
        btnSignUp?.setOnClickListener(this)

        if (session!!.loggedIn()) {
            startActivity(Intent(this@LoginRegisterActivity, MainActivity::class.java))
            finish()
        }
        val manager = this.supportFragmentManager
        if (findViewById<View?>(R.id.layout_portrait) != null) {
            manager.beginTransaction()
                .show(manager.findFragmentById(R.id.fragLogin)!!)
                .hide(manager.findFragmentById(R.id.fragRegister)!!)
                .commit()
        }
        if (findViewById<View?>(R.id.layout_land) != null) {
            manager.beginTransaction()
                .show(manager.findFragmentById(R.id.fragLogin)!!)
                .show(manager.findFragmentById(R.id.fragRegister)!!)
                .commit()
            textView?.setVisibility(View.GONE)
            tvSignUp?.setVisibility(View.GONE)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_forget_pass -> startActivity(
                Intent(
                    this@LoginRegisterActivity,
                    ForgetPasswordActivity::class.java
                )
            )
            R.id.tv_sign_up, R.id.btn_nav_sign_up -> startActivity(
                Intent(
                    this@LoginRegisterActivity,
                    SignUpActivity::class.java
                )
            )
            R.id.btn_login -> onLoginClicked()
            else -> {
            }
        }
    }

    private fun onLoginClicked() {
        val email = etEmail!!.text.toString().trim { it <= ' ' }
        val password = etPassword!!.text.toString()
        if (!email.isEmpty() && !password.isEmpty()) {
            if (db?.getUser(email, password)!!) {
                session?.setLoggedIn(true)
                val intent = Intent(this@LoginRegisterActivity, MainActivity::class.java)
                intent.putExtra(EMAIL, email)
                startActivity(intent)
                finish()
            } else Toast.makeText(this, "Wrong email or password", Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this, "One or more field is blank", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EMAIL = "email"
    }
}
