package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserProfileDao {

    @Query("SELECT * FROM userprofile")
    List<UserProfile> getAllUserProfiles();

    @Query("SELECT * FROM userprofile WHERE user_profile_id IN (:userIds)")
    List<UserProfile> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM userprofile WHERE user_profile_name LIKE :user_name AND "
            + "user_profile_password LIKE :user_password LIMIT 1")
    UserProfile findUserProfileByName(String user_name, String user_password);

    @Insert
    void insertAll(UserProfile... userProfiles);

    @Insert(onConflict = REPLACE)
    void insertUserProfile(UserProfile userProfile);

    @Delete
    void delete(UserProfile userProfile);
}
