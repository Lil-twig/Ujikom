package com.Ihsan.ujikom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.Ihsan.ujikom.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    //    private lateinit var binding : ActivitySignUpBinding
//    private lateinit var database : DatabaseReference
    private lateinit var binding : ActivitySignUpBinding
    private lateinit var firebaseAuth : FirebaseAuth
    //    private lateinit var actionBar: ActionBar
//    private lateinit var progressDialog: ProgressDialog
    private var namaOrangTua = ""
    private var password = ""
    private var nameOfTheKid = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // init firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()

        // handle click, btn SignUp
        binding.btnSignUp.setOnClickListener {
            validateData()
        }
        //handle click goto signup
        binding.linkToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    private fun validateData() {
        //get data
        namaOrangTua = binding.signNamaOrangTua.text.toString().trim()
        password = binding.signPw.text.toString().trim()
        nameOfTheKid = binding.signAnak.text.toString().trim()

        if (TextUtils.isEmpty(namaOrangTua)) {
            //username is empty
            binding.signNamaOrangTua.error = "Please enter Nama Orang Tua"
        }
        else if (TextUtils.isEmpty(nameOfTheKid)) {
            //pasword is empty
            binding.signPw.error = "Please enter Nama Anak"
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(nameOfTheKid).matches()){
            //invalid email format
            binding.signAnak.error = "Invalid email format"
        }
        else if (TextUtils.isEmpty(password)) {
            //email is empty
            binding.signPw.error = "Please enter Password"
        }
        else if (password.length <6) {
            // pasword must 6 character
            binding.signPw.error = "Password must atleast 6 character long"
        }
        else {
            // data is valid,goto data diri
            firebaseSignUp()
        }
    }

    private fun firebaseSignUp() {
        //create account
        firebaseAuth.createUserWithEmailAndPassword(nameOfTheKid, password)
            .addOnSuccessListener {
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Account created with email $email", Toast.LENGTH_SHORT).show()

                //intent activity to data diri
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            .addOnFailureListener { e->
                Toast.makeText(this, "SignUp Failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
