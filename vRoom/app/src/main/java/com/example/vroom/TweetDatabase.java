package com.example.vroom;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = (Tweet.class), version = 1, exportSchema = false)
public abstract class TweetDatabase extends RoomDatabase {
    public abstract TweetDao tweetDao();


}
