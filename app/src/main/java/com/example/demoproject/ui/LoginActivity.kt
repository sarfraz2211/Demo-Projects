package com.example.demoproject.ui

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.demoproject.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = "Terms"
        binding.termsTextView.text = Html.fromHtml("<u>Terms</u>", Html.FROM_HTML_MODE_LEGACY)
        events()

    }

    private fun events() {
        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.btnSignin.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

}