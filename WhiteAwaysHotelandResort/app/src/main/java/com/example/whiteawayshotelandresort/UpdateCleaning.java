package com.example.whiteawayshotelandresort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateCleaning extends AppCompatActivity {
    EditText roomno;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    Button confrmupdate;
    Spinner statusSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaningupdate);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("CleaningManagement");
        roomno = (EditText) findViewById(R.id.roomno);
        confrmupdate = (Button) findViewById(R.id.confrmupdate);
        statusSpinner = (Spinner) findViewById(R.id.statusSpinner);

        confrmupdate.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
                int rNumber = 0;
                try {
                    rNumber = Integer.parseInt(roomno.getText().toString());
                }catch(NumberFormatException nfe){
                    Toast.makeText(UpdateCleaning.this,"Invalid Room Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                String status = statusSpinner.getSelectedItem().toString();
                String rnum = roomno.getText().toString();
                databaseReference.child(rnum).child("status").setValue(status);
                clearFields();
                Toast.makeText(UpdateCleaning.this,"Status has been updated!",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void clearFields(){
        roomno.setText("");
        statusSpinner.setSelection(0);

    }
}
