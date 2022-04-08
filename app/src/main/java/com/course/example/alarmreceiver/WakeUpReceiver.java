package com.course.example.alarmreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.widget.Toast;

public class WakeUpReceiver extends BroadcastReceiver {

    private MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {

        //create media player for sound on alarm
        mp = MediaPlayer.create(context, R.raw.dingdong);
        mp.seekTo(0);
        mp.start();

        Toast.makeText(context, "Don't panic but your time is up!!!!.",
                Toast.LENGTH_LONG).show();

        // Vibrate the mobile phone
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
    }
}
