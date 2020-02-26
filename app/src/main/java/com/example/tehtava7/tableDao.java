package com.example.tehtava7;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface tableDao  {
    @Query("SELECT id,screenState,time  FROM Taulu ORDER BY id desc LIMIT 2")
    List<Taulu> getAll();

    @Insert
    void InsertTaulu(Taulu taulu);

    @Delete
    void DeleteTaulu(Taulu taulu);

}
