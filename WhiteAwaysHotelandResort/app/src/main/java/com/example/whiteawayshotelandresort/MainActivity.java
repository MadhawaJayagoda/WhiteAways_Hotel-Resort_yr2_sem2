package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void launchRoomMgmnt(View view){
        Intent intent = new Intent(this, MainActivity1.class);
        startActivity(intent);
    }
    public void launchCustMgmnt(View view){
        Intent intent = new Intent(this, ListCustomer.class);
        startActivity(intent);
    }
    public void launchClnMgmnt(View view){
        Intent intent = new Intent(this, cleaningmanagement.class);
        startActivity(intent);
    }

    public void employee_management(View view){
        Intent intent = new Intent(this, EmpMainActivity.class);
        startActivity(intent);
    }

}
