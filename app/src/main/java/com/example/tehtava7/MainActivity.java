package com.example.tehtava7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    tableDao td;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tietokanta db = Room.databaseBuilder(getApplicationContext(),
                tietokanta.class,"asd").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        this.td = db.tableDao();

        BroadcastReceiver mReceiver = new ScreenReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mReceiver, filter);



    }

    @Override
    protected void onResume() {

        TextView teksti = findViewById(R.id.teksti);

        String asd = "asd";
        Log.d(asd, "onRESUMESSSSSSSSSSSSSSSSSSSSSSS");


        for (Taulu s : td.getAll()){
            boolean n = s.screenState;
            String x;

            if (n == true)
                x = "kiinni";
            else
                x ="auki";

            teksti.append(s.time + " " + x + "\n");

 }


        super.onResume();
    }
}
