package com.example.lab1

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import android.app.Activity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPassword = findViewById<EditText>(R.id.etPassword)
        val rgPasswordMode = findViewById<RadioGroup>(R.id.rgPasswordMode)
        val btnOk = findViewById<Button>(R.id.btnOk)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        rgPasswordMode.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbShow -> {
                    etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                }
                R.id.rbHide -> {
                    etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                }
            }
            etPassword.setSelection(etPassword.text.length)
        }

        btnOk.setOnClickListener {
            val passwordText = etPassword.text.toString()

            if (passwordText.isEmpty()) {
                Toast.makeText(this, "Помилка: Будь ласка, введіть пароль!", Toast.LENGTH_SHORT).show()
            }
            else {
                tvResult.text = "Ваш введений пароль: $passwordText"
            }
        }
    }
}