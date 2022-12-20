package com.example.spacex_ships;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface ShipDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Ship> ships);

    @Query("DELETE FROM ships")
    void deleteAll();

    // Live Data list, realization observer pattern
    @Query("SELECT DISTINCT * FROM ships")
    LiveData<List<Ship>> getships();
}
