package com.example.vivianbabiryekulumba.townhall.room_persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface FavoriteVolOppDao {
    @Query("SELECT * FROM favorite_vol_opps")
    List<Favorite_Vol_Opps> getAll();

    @Query("SELECT * FROM favorite_vol_opps WHERE favorite_vol_opp_id IN (:favVolOppsIds)")
    List<Favorite_Vol_Opps> loadAllByIds(int[] favVolOppsIds);

    @Insert
    void insertAll(Favorite_Vol_Opps... favorite_vol_opps);

    @Insert(onConflict = REPLACE)
    void insertFavVolOpp(Favorite_Vol_Opps favorite_vol_opps);

    @Delete
    void delete(Favorite_Vol_Opps favorite_vol_opps);
}
