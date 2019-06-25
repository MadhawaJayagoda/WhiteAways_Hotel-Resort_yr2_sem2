package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ReservationActivity2 extends AppCompatActivity {

    EditText cust_name, no_of_adults, no_of_children;
    int day_count;
    String datein, dateout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation2);

        cust_name = (EditText) findViewById(R.id.input_customer_name);
        no_of_adults = (EditText) findViewById(R.id.input_num_adults);
        no_of_children = (EditText) findViewById(R.id.input_num_children);

        Intent intent = getIntent();
        day_count = intent.getIntExtra("DAY_COUNT", 0);
        datein = intent.getStringExtra("DATE_IN");
        dateout = intent.getStringExtra("DATE_OUT");
    }

    public void onClickNext(View view){

        String customer_name = cust_name.getText().toString();
        Singleton.getInstance().setReservation_made_by(customer_name);
        Intent intent = new Intent(this, DisplayPayment.class);
        intent.putExtra("DAY_COUNT", day_count);
        startActivity(intent);
    }
}
