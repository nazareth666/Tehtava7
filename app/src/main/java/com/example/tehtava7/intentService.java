package com.example.tehtava7;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.room.Room;

public class intentService extends IntentService {
    tableDao td;

    public intentService(){
        super("x");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        boolean screen = intent.getBooleanExtra("state",false);
        String time = intent.getStringExtra("time");
        Taulu taulu= new Taulu();
        tietokanta db = Room.databaseBuilder(getApplicationContext(),
                tietokanta.class,"asd").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        this.td = db.tableDao();

        taulu.time = time;
        taulu.screenState = screen;
        String iS_LOG = "IS_LOG";
        Log.d(iS_LOG, "Insertoidaan " + taulu.time);
        td.InsertTaulu(taulu);


    }
}
