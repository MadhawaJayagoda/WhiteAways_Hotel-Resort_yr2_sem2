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

public class deleteCustomer extends AppCompatActivity {

 Button deletebtn;
 EditText id;
 DatabaseReference databaseReference;
 FirebaseDatabase firebaseDatabase;

@Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);

  setContentView(R.layout.deletecustomer);
  id = (EditText) findViewById(R.id.id);
  firebaseDatabase = FirebaseDatabase.getInstance();
  databaseReference = firebaseDatabase.getReference("Customer");
  deletebtn = (Button) findViewById(R.id.deleteBtn);

  deletebtn.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    if(TextUtils.isEmpty(id.getText().toString())) {
        Toast.makeText(deleteCustomer.this, "Please enter an ID", Toast.LENGTH_SHORT).show();
        return;

    }
        String idstr = id.getText().toString();
        databaseReference.child(idstr).removeValue();
        Toast.makeText(deleteCustomer.this, "Record deleted successfully", Toast.LENGTH_SHORT).show();

        launchListCustomer();


   }
  });

 }
    public void launchListCustomer() {
        Intent intent = new Intent(this, ListCustomer.class);
        startActivity(intent);
    }
    public void launchListCustomer(View view){
        Intent intent = new Intent(this, ListCustomer.class);
        startActivity(intent);
    }
}
