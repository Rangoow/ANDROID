package com.example.vroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TweetDatabase db = Room.databaseBuilder(this, TweetDatabase.class, "ma_bdd.db").build();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                Tweet tweet = new Tweet();
                tweet.setId("190334");
                tweet.setText("1, 2, 3, Viva Android");
                db.tweetDao().insert(tweet);
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                List<Tweet> tweets = db.tweetDao().getAll();
                for (Tweet tweet : tweets) {
                    Log.d("BDD",tweet.getText());
                }
            }
        });
    }
}
