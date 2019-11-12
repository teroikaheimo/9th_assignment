package com.example.a9th_assingment.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoUser {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(EntityUser user);

    @Query("SELECT username,password FROM users WHERE username = :username & password = :password; ")
    List<EntityUser> getUser(String username, String password);
}
