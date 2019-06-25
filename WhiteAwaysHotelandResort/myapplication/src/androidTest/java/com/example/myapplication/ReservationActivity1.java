package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationActivity1 extends AppCompatActivity {

    EditText room_id;
    EditText check_in_date;
    EditText check_out_date;
    TextView display_day_count;
    Button next_btn;
    Button calculate;
    String date_in, date_out;
    int roomID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation1);

        Intent intent = getIntent();

        room_id = (EditText) findViewById(R.id.input_room_id);
        check_in_date = (EditText) findViewById(R.id.input_checkin);
        check_out_date = (EditText) findViewById(R.id.input_checkout);
        display_day_count = (TextView) findViewById(R.id.display_days);
        calculate = (Button) findViewById(R.id.calculate);
        next_btn = (Button) findViewById(R.id.next);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCalculate();
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNextButton();
            }
        });

    }

    public void onClickCalculate(){

        try {
            roomID = Integer.parseInt(room_id.getText().toString());
            date_in = check_in_date.getText().toString();
            date_out = check_out_date.getText().toString();

            //Setting values to the room object.
            Singleton.getInstance().setRoomID(roomID);
            Singleton.getInstance().setDate_in(date_in);
            Singleton.getInstance().setDate_out(date_out);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date datein = format.parse(date_in);
            Date dateout = format.parse(date_out);

            long dayCount = getDateDiff(datein, dateout, TimeUnit.DAYS);
            //Setting values to the room object.
            Singleton.getInstance().setDay_count(dayCount);
            display_day_count.setText(String.valueOf(dayCount));


        }catch(ParseException e){
                e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
            Log.i("Error" , "roomID creates the problem");
        }

    }

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    public boolean validateEmptyFields(){
        if((TextUtils.isEmpty(room_id.getText().toString()) || TextUtils.isEmpty(check_in_date.getText().toString()) || TextUtils.isEmpty(check_out_date.getText().toString()) ) == true){
            return true;      // if return true, empty fields exist.
        }else{
            return false;     // no empty fields exist.
        }
    }

    public boolean validateEmptyDayCountField(){
        if(TextUtils.isEmpty(display_day_count.getText().toString()) == true){
            return true;      // if return true, field is empty.
        }else{
            return false;     //  field is not empty.
        }
    }

    public void onClickNextButton() {
        if(validateEmptyFields() == true){
            Toast.makeText(ReservationActivity1.this, "Error: One or more Fields are Empty", Toast.LENGTH_LONG).show();
        }else if(validateEmptyDayCountField() == true){
            Toast.makeText(ReservationActivity1.this, "Please calculate the number of days to proceed !", Toast.LENGTH_LONG).show();
        }else {

            try {

                int day_count = Integer.parseInt(display_day_count.getText().toString());
                Intent intent = new Intent(this, ReservationActivity2.class);
                intent.putExtra("DAY_COUNT", day_count);
                startActivity(intent);
            }catch(Exception e){
                e.printStackTrace();
                Log.i("Error", "day_count creates the problem");
            }

        }
    }
}
