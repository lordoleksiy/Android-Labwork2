package com.example.labwork2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.labwork2.fragments.Input
import com.example.labwork2.fragments.Main
import com.example.labwork2.fragments.Result


class MainActivity : AppCompatActivity(), Input.OnPasswordEnteredListener, Result.OnBackEvent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(Main())
    }



    private fun setFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeholder, fragment)
            .commit()
    }

    override fun onPasswordEntered(pass: String) {
        setFragment(Result(pass))
    }

    override fun backEvent() {
        setFragment(Main())
    }
}