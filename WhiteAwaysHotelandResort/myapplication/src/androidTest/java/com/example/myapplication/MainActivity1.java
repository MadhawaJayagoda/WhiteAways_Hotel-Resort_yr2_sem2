package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity1 extends AppCompatActivity {

    Button room_reserv;
    Button list_available_rooms;
    Button list_occupied_rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        room_reserv = (Button) findViewById(R.id.room_reservation);
        list_available_rooms = (Button) findViewById(R.id.list_available);
        list_occupied_rooms = (Button) findViewById(R.id.list_occupied);

        Intent intent = getIntent();
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
