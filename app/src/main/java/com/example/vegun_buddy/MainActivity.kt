package com.example.vegun_buddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.postalcode)
        var btn_srch = findViewById<Button>(R.id.srch)
        fun useRegex(input: String): Boolean {
            var p: Pattern = Pattern.compile("[A-Za-z][0-9][A-Za-z][ -][0-9][A-Za-z][0-9]")
            var m: Matcher = p.matcher(input)
            return m.matches()
        }
        editText.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                //var pc = editText.text
                if (useRegex(editText.text.toString())) {
                    btn_srch.isEnabled = true
                 } else {
                    btn_srch.isEnabled = false

                 }

            }
        })
    }
}