package com.example.labwork2.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.labwork2.R


class Result(val pass: String) : Fragment() {
    private lateinit var onBackEvent: OnBackEvent
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    interface OnBackEvent{
        public fun backEvent(){}
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBackEvent) {
            onBackEvent = context
        }
    }

    override fun onStart() {
        val textView: TextView = requireActivity().findViewById(R.id.textResult)

        textView.text = pass

        requireActivity().findViewById<Button>(R.id.backButton).setOnClickListener {
            onBackEvent.backEvent()
        }
        super.onStart()
    }
}