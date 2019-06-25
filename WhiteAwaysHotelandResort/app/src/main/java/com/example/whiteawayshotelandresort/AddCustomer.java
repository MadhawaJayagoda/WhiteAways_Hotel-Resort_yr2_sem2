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

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AddCustomer extends AppCompatActivity {

    Button addcustbtn;
    EditText fname;
    EditText checkin;
    EditText roomno;
    EditText checkout;
    EditText id;
    DatabaseReference databaseReference;
    List<Customer> customers;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcustomer);
        customers = new ArrayList<Customer>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Customer");

        addcustbtn = (Button) findViewById(R.id.addcustbtn);
        fname = (EditText) findViewById(R.id.fname);
        checkin = (EditText) findViewById(R.id.checkin);
        checkout = (EditText) findViewById(R.id.checkout);
        roomno= (EditText) findViewById(R.id.roomno);
        id = (EditText) findViewById(R.id.id);

            addcustbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(TextUtils.isEmpty(id.getText().toString())) {
                        Toast.makeText(AddCustomer.this, "Please enter an ID", Toast.LENGTH_SHORT).show();

                        return;
                    }
                    if(TextUtils.isEmpty(roomno.getText().toString())) {
                        Toast.makeText(AddCustomer.this, "Please enter a room number", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(TextUtils.isEmpty(fname.getText().toString())) {
                        Toast.makeText(AddCustomer.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(TextUtils.isEmpty(checkin.getText().toString())) {
                        Toast.makeText(AddCustomer.this, "Please enter a check-in date", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(TextUtils.isEmpty(checkout.getText().toString())) {
                        Toast.makeText(AddCustomer.this, "Please enter a checkout date", Toast.LENGTH_SHORT).show();
                        return;
                    }
                        String name = fname.getText().toString();
                        String room = roomno.getText().toString();
                        String checkinstr = checkin.getText().toString();
                        String idstr = id.getText().toString();
                        String checkoutstr = checkout.getText().toString();


                        String id = databaseReference.push().getKey();
                        Customer c1 = new Customer(idstr, name, room, checkinstr, checkoutstr);
                        databaseReference.child(idstr).setValue(c1);
                        clearFields();
                        Toast.makeText(AddCustomer.this, "Record added successfully", Toast.LENGTH_SHORT).show();
                        launchListCustomer();


                }
            });
    }
    public void clearFields(){
        id.setText("");
        fname.setText("");
        roomno.setText("");
        checkin.setText("");
        checkout.setText("");
    }
    public void launchActivity2 (View view){
        Intent intent = new Intent(this, ListCustomer.class);
        startActivity(intent);
    }
    public void launchListCustomer() {
        Intent intent = new Intent(this, ListCustomer.class);
        startActivity(intent);
    }
}
