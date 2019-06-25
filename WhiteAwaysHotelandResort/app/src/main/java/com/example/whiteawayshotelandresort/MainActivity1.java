package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public void changeSceneToMainActivity2(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void onClickUpdateStatus(View view){
        Intent intent = new Intent(this, UpdateStatus.class);
        startActivity(intent);
    }

    public void onClickListOcuupiedRooms(View view){
        Intent intent = new Intent(this, DisplayOccupiedRooms.class);
        startActivity(intent);
    }

    public void onClickListAvailableRooms(View view){
        Intent intent = new Intent(this, DisplayAvailableRooms.class);
        startActivity(intent);
    }

    public void onClickReservation(View view){
        Intent intent = new Intent(this, ReservationActivity1.class);
        startActivity(intent);
    }
}
