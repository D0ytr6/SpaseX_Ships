package com.example.spacex_ships;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;

@Database(entities = {Ship.class},version = 3)
public abstract class ShipDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "Ship";
    public abstract ShipDAO ShipDAO();
    public static volatile ShipDatabase INSTANCE = null;

    public static ShipDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ShipDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ShipDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    public static Callback callback = new Callback() {
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyn(INSTANCE);
        }
    };

    static class PopulateDbAsyn extends AsyncTask<Void,Void,Void> {

        private ShipDAO ShipDAO;

        public PopulateDbAsyn(ShipDatabase shipDatabase) {
            ShipDAO=shipDatabase.ShipDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            ShipDAO.deleteAll();
            return null;
        }
    }
}
