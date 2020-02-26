package com.example.tehtava7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

public class ScreenReceiver extends BroadcastReceiver {

    public static boolean wasScreenOn;

    @Override
    public void onReceive(Context context, Intent intent) {
        String screen = "asd";
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            wasScreenOn = false;
            screen = "Kiinni";
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            wasScreenOn = true;
            screen = "Auki";
        }

        String time = Calendar.getInstance().getTime().toString();

        Intent i = new Intent(context, intentService.class);
        i.putExtra("state", wasScreenOn);
        i.putExtra("time", time);
        context.startService(i);



        String log = "LOG" + time;
        Log.d(log, "Näyttö " + screen);
    }


}
