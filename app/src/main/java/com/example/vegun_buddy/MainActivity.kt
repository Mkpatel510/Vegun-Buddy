package com.example.vegun_buddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.postalcode)
        var btn_srch = findViewById<Button>(R.id.srch)
        editText.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                var pc = editText.text
                if (this.useRegex(pc)) {
                    btn_srch.isEnabled = true
                 } else {
                    btn_srch.isEnabled = false
                 }
//                if(android.util.Patterns.EMAIL_ADDRESS.matcher(editText.text.toString()).matches())
//                    btn_srch.isEnabled = true
//                else
//                    btn_srch.isEnabled = false

            }

            fun useRegex(input: Editable): Boolean {
                val regex = Regex(pattern = "^([A-Za-z]d[A-Za-z][ ]d[A-Za-z]d)$", options = setOf(RegexOption.IGNORE_CASE))
                return regex.matches(editText.text)
            }
        })
    }
}