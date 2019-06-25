package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ListCustomer extends AppCompatActivity {
    ArrayList<String> customerArrayList = new ArrayList<>();
    ListView customerList;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    Button deleteBtn;
    ArrayAdapter<String> customerArrayAdapter;
    public void onStart(){
        super.onStart();
        setContentView(R.layout.listcustomers);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Customer");
        customerArrayAdapter = new ArrayAdapter<String>(this,R.layout.cust_list,R.id.custlist,customerArrayList);
        customerList = findViewById(R.id.customerlist);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    Customer c3 = ds.getValue(Customer.class);

                    customerArrayList.add(c3.getId()+"               "+c3.getFullname()+"             "+c3.getRoomno()+"           "+c3.getDatein()+"        "+c3.getDateout());
                }
                customerList.setAdapter(customerArrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void launchAdd(View view){
        Intent intent = new Intent(this, AddCustomer.class);
        startActivity(intent);
    }
    public void launchUpdate(View view){
        Intent intent = new Intent(this, UpdateCustomer.class);
        startActivity(intent);

    }
    public void launchDelete(View view) {
        Intent intent = new Intent(this, deleteCustomer.class);
        startActivity(intent);
    }


}
