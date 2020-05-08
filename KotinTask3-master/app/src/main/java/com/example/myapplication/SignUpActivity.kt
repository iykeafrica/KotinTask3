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
import com.example.myapplication.extras.LoremActivity


class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    var tvWhySignUp: TextView? = null
    var tvLoginFromSignUp: TextView? = null
    var etFirstName: EditText? = null
    var etSurname: EditText? = null
    var etEmailFromSignUp: EditText? = null
    var etPasswordFromSignUp: EditText? = null
    var etConfirmPassword: EditText? = null
    var btnSignUp: Button? = null

    var db: DbHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        tvWhySignUp = findViewById(R.id.tvWhySignUp)
        tvLoginFromSignUp = findViewById(R.id.tvLoginFromSignUp)
        etFirstName = findViewById(R.id.etFirstName)
        etSurname = findViewById(R.id.etSurname)
        etEmailFromSignUp = findViewById(R.id.etEmailSignUp)
        etPasswordFromSignUp = findViewById(R.id.etPasswordSignUp)
        etConfirmPassword = findViewById(R.id.etPasswordConfirm)
        btnSignUp = findViewById(R.id.btn_sign_up)

        db = DbHelper(this)

        tvWhySignUp?.setOnClickListener(this)
        tvLoginFromSignUp?.setOnClickListener(this)
        btnSignUp?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tvWhySignUp -> startActivity(
                Intent(
                    this@SignUpActivity,
                    LoremActivity::class.java
                )
            )
            R.id.tvLoginFromSignUp -> startActivity(
                Intent(
                    this@SignUpActivity,
                    LoginRegisterActivity::class.java
                )
            )
            R.id.btn_sign_up -> onSignUpClicked()
            else -> {
            }
        }
    }

    private fun onSignUpClicked() {
        val firstName = etFirstName!!.text.toString().trim { it <= ' ' }
        val surname = etSurname!!.text.toString()
        val email = etEmailFromSignUp!!.text.toString()
        val password = etPasswordFromSignUp!!.text.toString()
        val passwordConfirm = etConfirmPassword!!.text.toString()
        if (!firstName.isEmpty() && !surname.isEmpty() && !email.isEmpty() && !password.isEmpty() && !passwordConfirm.isEmpty()) { //            if (!(password.equals(passwordConfirm))){
//                Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
//            }
            db?.addUser(firstName, surname, email, password, passwordConfirm)
            Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show()
            finish()
        } else Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
    }
}
