package com.akashsoam.androidroommvvm.room_database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MartialArtDAO {
    @Insert
    void insertMartialArt(MartialArt martialArt);

    @Query("delete from martial_art_table")
    void deleteAllMartialArts();

    @Delete
    void deleteMartialArt(MartialArt MartialArt);

    @Query("select * from martial_art_table order by fav_martial_art asc")
    LiveData<List<MartialArt>> getAllMartialArtsInAlphabeticalOrder();

}
