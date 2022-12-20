package com.example.spacex_ships;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    public ShipDAO ShipDAO;
    public LiveData<List<Ship>> getAllShips;
    private ShipDatabase database;

    public Repository(Application application){
        database=ShipDatabase.getInstance(application);
        ShipDAO=database.ShipDAO();
        getAllShips=ShipDAO.getships();

    }

    public void insert(List<Ship> ships){
        new InsertAsyncTask(ShipDAO).execute(ships);

    }

    public LiveData<List<Ship>> getAllShips(){
        return getAllShips;
    }

    private static class InsertAsyncTask extends AsyncTask<List<Ship>,Void,Void> {

        private ShipDAO ShipDAO;

        public InsertAsyncTask(ShipDAO ShipDAO) {
            this.ShipDAO=ShipDAO;
        }
        @Override
        protected Void doInBackground(List<Ship>... lists) {
            ShipDAO.insert(lists[0]);
            return null;
        }
    }
}
