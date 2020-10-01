package com.example.submission3;


import androidx.room.Database;
import androidx.room.RoomDatabase;

/*
 * Membuat Class Database
 * Entity yang digunakan adalah Mahasiswa.class
 * Version = 1
 */
@Database(entities = {DaftarFavorite.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //Untuk mengakses Database menggunakan method abstract
    public abstract FavoriteDao favoriteDao();
}


