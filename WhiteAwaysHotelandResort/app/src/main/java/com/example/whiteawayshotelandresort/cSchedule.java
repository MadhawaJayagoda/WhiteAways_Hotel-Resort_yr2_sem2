package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class cSchedule extends AppCompatActivity {

    ArrayList<String> cleaningArrayList = new ArrayList<>();
    ListView cleanList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayAdapter<String> cleanArrayAdapter;
    public void onStart(){
        super.onStart();
        setContentView(R.layout.cschedule);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("CleaningManagement");
        cleanArrayAdapter = new ArrayAdapter<String>(this,R.layout.user_list,R.id.cleanInfo,cleaningArrayList);
        cleanList = findViewById(R.id.cleanList);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()) {
                    Cleaning c1 = ds.getValue(Cleaning.class);

                    cleaningArrayList.add(c1.getRoomnum()+"     "+" "+"            "+c1.getCleanType()+"    "+"     "+c1.getStatus()+"   "+"      "+c1.getCleanDate());
                }
                cleanList.setAdapter(cleanArrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        }




    public void launchDeleteScreen(View view){
        Intent intent = new Intent(cSchedule.this,DeleteCleaning.class);
        startActivity(intent);
    }

}
