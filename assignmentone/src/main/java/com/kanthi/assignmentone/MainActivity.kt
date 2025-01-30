package com.kanthi.assignmentone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewCounter: TextView
    private lateinit var buttonClickCounter: Button
    private lateinit var buttonStartService: Button

    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewCounter = findViewById(R.id.textViewCounter)
        buttonClickCounter = findViewById(R.id.buttonClickCounter)
        buttonStartService = findViewById(R.id.buttonStartService)

        // Reset counter when the app is launched
        resetCounter()

        buttonClickCounter.setOnClickListener {
            clickCount++
            textViewCounter.text = "Click count $clickCount"
        }

        buttonStartService.setOnClickListener {
            startLoggingService()
        }
    }

    override fun onPause() {
        super.onPause()
        // Reset counter when app goes to background
        resetCounter()
    }

    private fun resetCounter() {
        clickCount = 0
        textViewCounter.text = "Click count $clickCount"
    }

    private fun startLoggingService() {
        val intent = Intent(this, LoggingService::class.java)
        intent.putExtra("counterValue", clickCount)
        startService(intent)
    }
}