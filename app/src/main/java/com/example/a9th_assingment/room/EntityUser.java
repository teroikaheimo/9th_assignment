package com.example.a9th_assingment.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class EntityUser {
    @PrimaryKey(autoGenerate = true)
    int id_user;
    String username;
    String password;
}
