package com.akashsoam.androidroommvvm.room_database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MartialArt.class}, version = 1, exportSchema = false)
public abstract class MartialArtRoomDatabase extends RoomDatabase {


    public abstract MartialArtDAO martialArtDAO();//exposing the MartialArtDAO interface, it is like a getter to the MartialArtDAO object

    private static volatile MartialArtRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
     static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MartialArtRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (MartialArtRoomDatabase.class) {
                INSTANCE = Room.databaseBuilder(context, MartialArtRoomDatabase.class, "martial_art_database").build();
            }
        }
        return INSTANCE;
    }

    @Override
    public void clearAllTables() {

    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return null;
    }
}
