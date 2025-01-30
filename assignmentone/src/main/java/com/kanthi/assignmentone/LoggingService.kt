package com.kanthi.assignmentone

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class LoggingService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val counterValue = intent?.getIntExtra("counterValue", 0) ?: 0
        Log.d("LoggingService", "Current counter value: $counterValue")
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}