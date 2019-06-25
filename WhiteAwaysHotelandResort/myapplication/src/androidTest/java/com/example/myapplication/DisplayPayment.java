package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayPayment extends AppCompatActivity {

    TextView displayDetails;
    int day_count, room_id;
    String cus_name, dateIn, dateOut;
    Button confirm_btn;
    int price;

    DatabaseReference mRootRef;        // Database reference to the root directory.
    static DatabaseReference roomRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onStart();
        setContentView(R.layout.activity_display_payment);
        mRootRef = FirebaseDatabase.getInstance().getReference("customers");
        displayDetails = (TextView) findViewById(R.id.display_details );
        confirm_btn = (Button) findViewById(R.id.confirm);

        Intent intent = getIntent();
        day_count = intent.getIntExtra("DAY_COUNT", 0);

        //Obtaining values from SingletonObject;
        dateIn = Singleton.getInstance().getDate_in();
        dateOut = Singleton.getInstance().getDate_out();
        room_id = Singleton.getInstance().getRoomID();
        cus_name = Singleton.getInstance().getReservation_made_by();


        // Display details in the TextField.
        displayDetails.setText("Customer_Details Name : " + cus_name + "\n" + "Room ID :   " + room_id + "\n"
                + "Check In Date : " + dateIn + "\n" + "Check Out Date : " + dateOut + "\n" + "Number of days stayed :  "
                + day_count );

        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCustomerDetails();
                changeScenetoMainActivity();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        getPricePerNight(Singleton.getInstance().getRoomID());
        roomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Room room = dataSnapshot.getValue(Room.class);
                price = room.getPrice_per_night();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void getPricePerNight(int roomID){
        roomRef = FirebaseDatabase.getInstance().getReference("rooms").child(String.valueOf(roomID));
    }

    public void addCustomerDetails(){

        String id = mRootRef.push().getKey();

        Customer_Details customerDetails = new Customer_Details(id, room_id, dateIn, dateOut, day_count, cus_name);
        mRootRef.child(id).setValue(customerDetails);
        Toast.makeText(DisplayPayment.this, "Customer_Details added to the Databse successfully !", Toast.LENGTH_LONG);
    }

    public void changeScenetoMainActivity(){
        Intent intent = new Intent(this, MainActivity1.class);
        startActivity(intent);
    }
}
