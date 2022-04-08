package com.course.example.alarmreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this is a listener method for the button click
    public void startAlert(View view) {
        int requestCode = 123;

        EditText text = (EditText) findViewById(R.id.time);
        int i = Integer.parseInt(text.getText().toString());

        //create intent object for a broadcast
        Intent intent = new Intent(this, WakeUpReceiver.class);

        //create pendingIntent that will send a broadcast
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), requestCode, intent, 0);

        //create an alarm to trigger intent when it goes off.
        //it triggers in the number of seconds input
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i * 1000), pendingIntent);

        Toast.makeText(this, "Alarm set for " + i + " seconds",
                Toast.LENGTH_LONG).show();

        finish();
    }

}
