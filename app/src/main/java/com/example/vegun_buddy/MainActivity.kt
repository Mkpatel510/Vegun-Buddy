package com.example.vegun_buddy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: MaterialToolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setTitle("Vegan Buddy")
        setSupportActionBar(toolbar)
        val frameLayout: FrameLayout = findViewById(R.id.main_frameLayout)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navigationView: NavigationView = findViewById<NavigationView>(R.id.navigation)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Log.d("test", "Main Activity : OnCreate()")
        navigationView.setNavigationItemSelectedListener {
            Log.d("test", "Menu Id : ${it.itemId}")
            when (it.itemId) {
                R.id.profile -> {
//                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//                        drawerLayout.closeDrawer(GravityCompat.START)
//                    }
                    val newIntent = Intent(this, ProfilePage::class.java)
                    startActivity(newIntent)
                    true
                }
                else -> {
                    true
                }
            }
        }

        val editText = findViewById<EditText>(R.id.postalcode)
        var btn_srch = findViewById<Button>(R.id.srch)
        fun useRegex(input: String): Boolean {
            var p: Pattern = Pattern.compile("[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]")
            var m: Matcher = p.matcher(input)
            return m.matches()
        }
        editText.addTextChangedListener(object : TextWatcher {
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
        btn_srch.setOnClickListener {
            val value = editText.text
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()
        }
    }
}