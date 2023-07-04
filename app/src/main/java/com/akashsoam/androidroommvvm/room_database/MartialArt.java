package com.akashsoam.androidroommvvm.room_database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "martial_art_table")
public class MartialArt {
    //entity is roomDb table
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "fav_martial_art")
    public String mFavMartialArt;

    public MartialArt(@NonNull String favMartialArt) {
        this.mFavMartialArt = favMartialArt;
    }

    public String getmFavMartialArt() {
        return mFavMartialArt;
    }
}
