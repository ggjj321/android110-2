package com.example.a109590016_hw12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();

        ToggleButton alarmToggle = findViewById(R.id.toggleButton);

        alarmToggle.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton,
                                                 boolean isChecked) {
                        if(isChecked){
                            deliverNotification(MainActivity.this);
                        } else {
                            mNotificationManager.cancelAll();
                        }
                    }
                });
    }

    public void createNotificationChannel() {

        // Create a notification manager object.
        mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Stand up notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Notifies every 15 minutes to stand up and walk");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void deliverNotification(Context context) {
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.setTimeInMillis(System.currentTimeMillis());

        int setHour = 11;
        int setMinute = 11;

        int nowHour = calendarNow.get(Calendar.HOUR_OF_DAY);
        int nowMinute = calendarNow.get(Calendar.MINUTE);

        if(nowHour > setHour || ((nowHour == setHour) && (nowMinute == setMinute))){
            setHour += 24;
        }

        Calendar calendarSet = Calendar.getInstance();
        calendarSet.set(Calendar.HOUR_OF_DAY, setHour);
        calendarSet.set(Calendar.MINUTE, setMinute);
        calendarSet.set(Calendar.SECOND, 0);
        calendarSet.set(Calendar.MILLISECOND, 0);

        Intent contentIntent = new Intent(context, AlarmBroadcastReceiver.class);
        contentIntent.setAction("CLOCK_IN");
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        PendingIntent contentPendingIntent = PendingIntent.getBroadcast(this, 0, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long alarmSeconds = calendarSet.getTimeInMillis() - System.currentTimeMillis();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + alarmSeconds, contentPendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + alarmSeconds, contentPendingIntent);
        }
    }
}

