package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addcleaner extends AppCompatActivity {
    EditText roomno;
    EditText cleanDate;
    Button confirmbtn;
    Spinner typeSpinner;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    TextView statusText;
private static final String LOG_TAG = Addcleaner.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_addcleaner);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("CleaningManagement");
        roomno = (EditText) findViewById(R.id.roomno);
        cleanDate = (EditText) findViewById(R.id.cleanDate);
        confirmbtn = (Button) findViewById(R.id.confirmbtn);
        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        statusText = (TextView) findViewById(R.id.statusText);
        confirmbtn.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
                int rNumber = 0;
                try {
                     rNumber = Integer.parseInt(roomno.getText().toString());
                }catch(NumberFormatException nfe){
                    Toast.makeText(Addcleaner.this,"Invalid Room Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                String cleanD = cleanDate.getText().toString();
                String cleanType = typeSpinner.getSelectedItem().toString();
                String rnum = roomno.getText().toString();
                String status = statusText.getText().toString();
                Cleaning clean = new Cleaning(cleanType,cleanD,rNumber,status);
                databaseReference.child(rnum).setValue(clean);
                clearFields();
                Toast.makeText(Addcleaner.this,"Record created successfully",Toast.LENGTH_SHORT).show();


            }
            });
    }
    public void clearFields(){
        roomno.setText("");
        typeSpinner.setSelection(0);
        cleanDate.setText("");


    }

    public void launchSchedule(View view) {
        Log.d(LOG_TAG,"Button clicked");
        Intent intent = new Intent(this, cSchedule.class);
        startActivity(intent);
    }
}
