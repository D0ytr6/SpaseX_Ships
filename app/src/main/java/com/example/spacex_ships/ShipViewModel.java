package com.example.spacex_ships;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ShipViewModel extends AndroidViewModel {

    private Repository repository;
    public LiveData<List<Ship>> getAllShips;

    public ShipViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        getAllShips = repository.getAllShips();
    }

    public void insert(List<Ship> ships){
        repository.insert(ships);
    }

    public LiveData<List<Ship>> getAllShips()
    {
        return getAllShips;
    }
}
