package com.capstone.eratani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.view.get
import com.capstone.eratani.home.HomeActivity
import com.capstone.eratani.monitor.MonitorFragment
import com.capstone.eratani.profile.ProfileFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var selectedStatus: String
    private val TAG = LoginActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val inputEmail = findViewById<EditText>(R.id.textinputEmail)
        val inputPassword = findViewById<EditText>(R.id.textinputPassword)
        val status = resources.getStringArray(R.array.status)
        val inputStatus = findViewById<Spinner>(R.id.spinnerStatus)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        auth = FirebaseAuth.getInstance()

        if (inputStatus != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, status)
            inputStatus.adapter = adapter

            inputStatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selectedStatus = status[position]
//                    Toast.makeText(this@LoginActivity, selectedStatus, Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }

        btnLogin.setOnClickListener{
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please Fill Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{
                    if (!it.isSuccessful) {
                        return@addOnCompleteListener
                    } else {
//                        try {
//                            val fragmentProfile = ProfileFragment()
//                            val bundle = Bundle()
////                            val fragmentManager = this@LoginActivity.supportFragmentManager
//                            bundle.putString(ProfileFragment.EXTRA_STATUS, selectedStatus)
//                            Log.d(TAG, "hahiii: $status")
//                            fragmentProfile.arguments = bundle
//                                supportFragmentManager.beginTransaction()
//                                        .apply {
//                                            replace(R.id.profileFragment, fragmentProfile)
//                                            addToBackStack(null)
//                                            commit()
//                                        }
//                        } catch (e: Exception) {
//                            Toast.makeText(this@LoginActivity, e.message, Toast.LENGTH_SHORT).show()
//                            e.printStackTrace()
//                        }

                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    }
                }
                .addOnFailureListener{
                    Log.d("Main", "Failed: ${it.message}")
                    Toast.makeText(this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun onBackPressed() {
        Log.d(TAG, "Back Press Disabled!")
    }
}