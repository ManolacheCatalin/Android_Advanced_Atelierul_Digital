package com.app.shopwithus.presentation.ui.notification;

import android.app.Notification;
import android.content.Context;

import androidx.core.app.NotificationCompat;

public class NotificationFactory {
    public static Notification createNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, ConfirmOrderNotificationFactory.CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Order confirmed!")
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setPriority(Notification.PRIORITY_MAX)
                .setAutoCancel(true);
        return builder.build();
    }
}
