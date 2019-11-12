package com.example.a9th_assingment.room;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = "username", unique = true)})
public class EntityUser {
    @PrimaryKey(autoGenerate = true)
    int id_user;
    public String username;
    public String password;
}
