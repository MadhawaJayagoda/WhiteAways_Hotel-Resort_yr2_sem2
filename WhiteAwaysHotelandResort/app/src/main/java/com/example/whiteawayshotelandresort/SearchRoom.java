package com.example.whiteawayshotelandresort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SearchRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_room);

        Intent intent = getIntent();
    }

    public void onClickSearch(View view){
        Intent intent = new Intent(this, DisplaySearchResults.class);
        startActivity(intent);
    }
}
