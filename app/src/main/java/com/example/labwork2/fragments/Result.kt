package com.example.labwork2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.labwork2.Data
import com.example.labwork2.R


class Result : Fragment() {
    private  lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }
    companion object{
        fun newInstance() = Result()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.textResult)

        view.findViewById<Button>(R.id.showButton).setOnClickListener {
            val text = Data.password
            if (text.isEmpty()){
                Toast.makeText(context, "You didn't input any data!", Toast.LENGTH_SHORT).show()
            }
            else{
                textView.text = text
            }
        }

        view.findViewById<Button>(R.id.clearButton).setOnClickListener {
            Data.password = ""
            textView.text = ""
        }
    }
}