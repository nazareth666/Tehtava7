package com.example.tehtava7;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Taulu {
    @PrimaryKey(autoGenerate = true) public int id;
    @NonNull public boolean screenState;
    @NonNull public String time;
}
