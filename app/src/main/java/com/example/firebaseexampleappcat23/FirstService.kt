package com.example.firebaseexampleappcat23

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

private const val TAG = "FirstService"

class FirstService : Service() {

    private var counter: Int = 0

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: Service created")
        // here you setup some data before starting the service
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: Service started")
        // here is when the service is actually running
        var message = ""

        // getting information from my intent
        intent?.let {
            message = it.getStringExtra("MY_VALUE2") ?: "No message found"
            counter = it.getIntExtra("MY_VALUE", 0)
        }

        // simple counter
        for (count in counter..20) {
            // displaying message to the user
            Toast.makeText(baseContext, "$message: $count", Toast.LENGTH_LONG).show()
        }

        // stopping service when it gets to 20
        if (counter == 20) stopService(intent)

        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Service stopped")
    }
}