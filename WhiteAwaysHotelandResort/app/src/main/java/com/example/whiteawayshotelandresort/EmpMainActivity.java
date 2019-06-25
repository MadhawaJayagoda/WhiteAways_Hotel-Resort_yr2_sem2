package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EmpMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_emp);

        Intent intent = getIntent();
    }

    public void onClickAddEmployee(View view){
        Intent intent = new Intent(this, AddEmployee.class);
        startActivity(intent);
    }

    public void onClickUpdateEmployee(View view){
        Intent intent = new Intent(this, UpdateEmployee.class);
        startActivity(intent);
    }

    public void onClickDeleteEmployee(View view){
        Intent intent = new Intent(this, DeleteEmployee.class);
        startActivity(intent);
    }

    public void onClickLeave(View view){
        Intent intent = new Intent(this, EmployeeLeave.class);
        startActivity(intent);
    }


}
