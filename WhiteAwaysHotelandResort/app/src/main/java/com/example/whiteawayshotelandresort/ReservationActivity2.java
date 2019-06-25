package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ReservationActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation2);

        Intent intent = getIntent();
    }

    public void onClickNext(View view){
        Intent intent = new Intent(this, DisplayPayment.class);
        startActivity(intent);
    }
}
