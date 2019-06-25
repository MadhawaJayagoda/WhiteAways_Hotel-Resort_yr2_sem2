package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class UpdateCustomer extends AppCompatActivity {

    Button sendbtn;
    EditText checkout;
    EditText checkin;
    EditText roomnum;
    EditText id;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatecustomer);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Customer");

        sendbtn =(Button)findViewById(R.id.sendbtn);
        id = (EditText)findViewById(R.id.id);
        roomnum =(EditText)findViewById(R.id.roomnum);
        checkin = (EditText) findViewById(R.id.checkin);
        checkout = (EditText)findViewById(R.id.checkout);

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(id.getText().toString())) {
                    Toast.makeText(UpdateCustomer.this, "Please enter an ID", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(TextUtils.isEmpty(roomnum.getText().toString())) {
                    Toast.makeText(UpdateCustomer.this, "Please enter room number", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(TextUtils.isEmpty(checkin.getText().toString())) {
                    Toast.makeText(UpdateCustomer.this, "Please enter a check-in date", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(TextUtils.isEmpty(checkout.getText().toString())) {
                    Toast.makeText(UpdateCustomer.this, "Please enter a check out date", Toast.LENGTH_SHORT).show();

                    return;
                }

                    String idstr = id.getText().toString();
                    String roomno = roomnum.getText().toString();
                    String checkinstr = checkin.getText().toString();
                    String checkoutstr = checkout.getText().toString();

                    databaseReference.child(idstr).child("datein").setValue(checkinstr);
                    Toast.makeText(UpdateCustomer.this, "Checkin time has been updated", Toast.LENGTH_SHORT).show();
                    databaseReference.child(idstr).child("dateout").setValue(checkoutstr);
                    clearFields();
                    Toast.makeText(UpdateCustomer.this, "Checkout time has been updated", Toast.LENGTH_SHORT).show();
                    launchListCustomer();
            }
        });

    }
    public void clearFields(){
        id.setText("");
        checkin.setText("");
        checkout.setText("");
        roomnum.setText("");
    }

    public void launchList(View view){
        Intent intent = new Intent(this, ListCustomer.class);
        startActivity(intent);
    }
    public void launchListCustomer() {
        Intent intent = new Intent(this, ListCustomer.class);
        startActivity(intent);
    }
}
