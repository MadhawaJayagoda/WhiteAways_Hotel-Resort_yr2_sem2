package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class cleaningmanagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaningmanagement);
    }
    public void launchSchedule(View view) {
        Intent intent = new Intent(this, cSchedule.class);
        startActivity(intent);
    }
    public void launchAddCleaner(View view){
        Intent intent = new Intent(this, Addcleaner.class);
        startActivity(intent);

    }
    public void launchcleanUpdate(View view){
        Intent intent = new Intent(this, UpdateCleaning.class);
        startActivity(intent);
    }

}
