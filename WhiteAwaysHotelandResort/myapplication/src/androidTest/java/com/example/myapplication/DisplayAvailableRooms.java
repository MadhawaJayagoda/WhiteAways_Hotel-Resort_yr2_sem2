package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayAvailableRooms extends AppCompatActivity {

    ListView listViewCustomers;
    DatabaseReference mRootRef;        // Database reference to the root directory.

    List<Customer_Details> customerDetailsList;

    String selectedCustomerID, selectedCustomerustomerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_available_rooms);

        Intent intent = getIntent();

        listViewCustomers = (ListView) findViewById(R.id.listViewCustomers);
        mRootRef = FirebaseDatabase.getInstance().getReference("customers");
        customerDetailsList = new ArrayList<>();

        listViewCustomers.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Customer_Details customerDetails = customerDetailsList.get(position);
                selectedCustomerID = String.valueOf(customerDetails.getCustomerID());
                selectedCustomerustomerName = customerDetails.getReservation_made_by();
                showDeleteDialog(selectedCustomerID, selectedCustomerustomerName);
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                customerDetailsList.clear();    // Clear any before added data

                // Executed whenever data changes in the Databse
                for(DataSnapshot customerSnapshot : dataSnapshot.getChildren()){
                    Customer_Details customerDetails = customerSnapshot.getValue(Customer_Details.class);

                    customerDetailsList.add(customerDetails);
                }

                Customer_Details_List adapter = new Customer_Details_List(DisplayAvailableRooms.this, customerDetailsList);
                listViewCustomers.setAdapter(adapter);    //attaching to artistListView.
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // When there is a Database Error
            }
        });

    }

    public void showDeleteDialog(final String customerID, final String customerName){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog1, null);

        dialogBuilder.setView(dialogView);

        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDelete);

        dialogBuilder.setTitle("Delete Customer_Details :  " + customerName);

        //creating the alert dialog using the builder
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCustomer(customerID);
                alertDialog.dismiss();
            }
        });

    }

    private void deleteCustomer(String customerID) {
        DatabaseReference DBrefCustomer = FirebaseDatabase.getInstance().getReference("customers").child(customerID);

        //This will remove the tree reference from the database.
        DBrefCustomer.removeValue();

        Toast.makeText(this, "Customer_Details details deleted successfully !", Toast.LENGTH_LONG).show();
    }

}
