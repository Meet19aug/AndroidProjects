package com.example.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.send);

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
//        {
//            NotificationChannel channel=new NotificationChannel("My Notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager notificationManager=getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//
//        }
        send.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public void onClick(View v) {
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");
//                builder.setContentTitle("My title");
//                builder.setContentText("This is notification demo");
//                builder.setSmallIcon(R.drawable.notification);
//                builder.setAutoCancel(true);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");

                builder.setSmallIcon(R.drawable.notification);
                builder.setContentTitle("Notification Example");
                builder.setContentText("This is a notification message");
                builder.setAutoCancel(true);
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                Intent notificationIntent = new Intent(MainActivity.this, Notification.class);
                notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                notificationIntent.putExtra("message", "This is a notification message");
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent,
                        PendingIntent.FLAG_MUTABLE);
                builder.setContentIntent(pendingIntent);

                NotificationManager managerCompat= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                managerCompat.notify(1,builder.build());

            }
        });
    }
}