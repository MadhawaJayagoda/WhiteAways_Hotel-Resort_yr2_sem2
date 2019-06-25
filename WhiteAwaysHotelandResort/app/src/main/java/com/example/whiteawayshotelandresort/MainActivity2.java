package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClickBack(View view){
        Intent intent = new Intent(this, MainActivity1.class);
        startActivity(intent);
    }

    public void onClickAddNewRoom(View view){
        Intent intent = new Intent(this, AddNewRoom.class);
        startActivity(intent);
    }

    public void onClickUpdateRoom(View view){
        Intent intent = new Intent(this, UpdateRoom.class);
        startActivity(intent);
    }

    public void onClickSearchRoom(View view){
        Intent intent = new Intent(this, SearchRoom.class);
        startActivity(intent);
    }

    public void onClickDeleteRoom(View view){
        Intent intent = new Intent(this, DeleteRoom.class);
        startActivity(intent);
    }


}
