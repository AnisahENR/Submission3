package com.example.submission3;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

public interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMahasiswa(DaftarFavorite mahasiswa);

}
