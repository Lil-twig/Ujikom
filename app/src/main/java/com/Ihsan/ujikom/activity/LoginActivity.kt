package com.Ihsan.ujikom.activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.Ihsan.ujikom.R
import com.Ihsan.ujikom.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding :ActivityLoginBinding
    private lateinit var firebaseAuth : FirebaseAuth
//    private lateinit var actionBar: ActionBar
//    private lateinit var progressDialog: ProgressDialog
    private var nameOfTheKid = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        actionBar = supportActionBar!!
//        actionBar.title = "Login"
//
//        progressDialog = ProgressDialog(this)
//        progressDialog.setTitle("Please Wait...")
//        progressDialog.setMessage("Logging In...")
//        progressDialog.setCanceledOnTouchOutside(false)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.linkToSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            validateData()
        }

    }

    private fun validateData() {

        nameOfTheKid = binding.edtNamaAnakLogin.text.toString().trim()
        password = binding.pwLogin.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(nameOfTheKid).matches()) {
            binding.edtNamaAnakLogin.error = "Invalid email format"
        }

        else if (TextUtils.isEmpty(password)) {
            binding.pwLogin.error = "Please Enter The Password"
        }

        else {

            firebaseLogin()

        }

    }

    private fun firebaseLogin() {

//        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(nameOfTheKid, password)
            .addOnSuccessListener {

//                progressDialog.dismiss()
                val fireBaseUser = firebaseAuth.currentUser
                val email = fireBaseUser!!.email
                Toast.makeText(this, "Logged in as $email", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()



            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Login Failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }

    }

    private fun checkUser() {
        val firebaseAuth = firebaseAuth.currentUser
        if (firebaseAuth != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}