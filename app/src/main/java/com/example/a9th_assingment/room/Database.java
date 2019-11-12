package com.example.a9th_assingment.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {EntityUser.class, EntityLoginLog.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static volatile Database INSTANCE;

    static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Database.class, "database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract DaoUser daoUser();

    public abstract DaoLoginLog daoLoginLog();
}
