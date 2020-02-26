package com.example.tehtava7;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Taulu.class},version = 5)
public abstract class tietokanta extends RoomDatabase {
    public  static final String NIMI = "asd";
    public abstract tableDao tableDao();
}
