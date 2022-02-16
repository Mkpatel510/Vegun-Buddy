package com.example.vegun_buddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val toolbar : MaterialToolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val frameLayout: FrameLayout = findViewById(R.id.main_frameLayout)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navigationView: NavigationView = findViewById(R.id.navigation)
        ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)

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