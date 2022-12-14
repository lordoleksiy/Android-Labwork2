package com.example.labwork2.fragments

import CustomPassword
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.labwork2.R


class Input : Fragment() {
    private lateinit var passwordEnteredListener: OnPasswordEnteredListener

    interface OnPasswordEnteredListener {
        public fun onPasswordEntered(pass: String){}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnPasswordEnteredListener) {
            passwordEnteredListener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText: EditText = view.findViewById(R.id.passwordInput)
        view.findViewById<RadioGroup>(R.id.radioGroup).setOnCheckedChangeListener { group, id ->
            if (id == R.id.radioShow){
                editText.inputType = InputType.TYPE_CLASS_TEXT
                editText.transformationMethod = null
            }
            else{
                editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                editText.transformationMethod = CustomPassword()
            }
            editText.setSelection(editText.text.length)
        }

        view.findViewById<Button>(R.id.button).setOnClickListener {
            val text = editText.text.toString()
            processText(text)
        }
    }

    private fun processText(text: String = ""){
        when {
            text.isEmpty() -> {
                Toast.makeText(context, "Input any text!", Toast.LENGTH_SHORT).show()
            }
            text.all { it.isLetter() } -> {
                Toast.makeText(context, "Your password must contain both letters and numbers", Toast.LENGTH_SHORT).show()

            }
            text.all { it.isDigit() } -> {
                Toast.makeText(context, "Your password must contain both letters and numbers", Toast.LENGTH_SHORT).show()
            }
            else -> {
                passwordEnteredListener.onPasswordEntered(text)
            }
        }
    }
    companion object{
        @JvmStatic
        fun newInstance() = Input()
    }
}