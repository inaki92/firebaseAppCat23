package com.example.firebaseexampleappcat23

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

private const val TAG = "MyFirebaseService"

class MyFirebaseService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val title = message.notification?.title ?: "No title found"
        val description = message.notification?.body ?: "No message found"

        Log.d(TAG, "onMessageReceived: $title , $description")

        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setContentText(description)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.ic_launcher_background).apply {
                priority = NotificationCompat.PRIORITY_HIGH
            }
            .build()

        val notificationChannel = NotificationChannel(CHANNEL_ID, "FirebaseChannel", IMPORTANCE_HIGH)

        (applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager).apply {
            createNotificationChannel(notificationChannel)

            notify(notId, notification)
        }
    }

    companion object {
        private const val CHANNEL_ID = "FIREBASE_CHANNEL"
        private const val notId = 432
    }
}