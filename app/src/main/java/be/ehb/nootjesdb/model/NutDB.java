package be.ehb.nootjesdb.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Nut.class}, version = 1)
public abstract class NutDB extends RoomDatabase {

    private static NutDB instance;
    public static final ExecutorService DB_EXECUTOR_SERVICE = Executors.newFixedThreadPool(4);

    public static NutDB getInstance(Context applicationContext) {
        if(instance == null) {
            instance = Room.databaseBuilder(applicationContext, NutDB.class, "nut.db").build();
        }
        return instance;
    }

    public abstract NutDAO getNutDAO();
}
