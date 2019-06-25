package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DeleteCleaning extends AppCompatActivity{
    EditText roomno;
    Button deleteBtn;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
   protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);

       setContentView(R.layout.deletecleaning);
       roomno = (EditText) findViewById(R.id.roomno);
       firebaseDatabase = FirebaseDatabase.getInstance();
       databaseReference = firebaseDatabase.getReference("CleaningManagement");
       deleteBtn = (Button) findViewById(R.id.deleteBtn);

       deleteBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(TextUtils.isEmpty(roomno.getText().toString())){
                   Toast.makeText(DeleteCleaning.this,"Please enter an ID",Toast.LENGTH_SHORT).show();
                   return;

               }
               String rnum = roomno.getText().toString();
               databaseReference.child(rnum).removeValue();
                launchSchedule();


           }
       });
   }


    public void launchSchedule(){
        Intent intent = new Intent(this, cSchedule.class);
        startActivity(intent);
    }
    public void launchSchedule(View view){
        Intent intent = new Intent(this, cSchedule.class);
        startActivity(intent);
    }
}
