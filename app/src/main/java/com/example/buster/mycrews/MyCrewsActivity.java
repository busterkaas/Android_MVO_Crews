package com.example.buster.mycrews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MyCrewsActivity extends AppCompatActivity {

    LinearLayout crew1;
    LinearLayout crew2;
    LinearLayout crew3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_crews);
        crew1 = (LinearLayout) findViewById(R.id.crew1);
        crew2 = (LinearLayout) findViewById(R.id.crew2);
        crew3 = (LinearLayout) findViewById(R.id.crew3);

        crew1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCrew();
            }
        });
        crew2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCrew();
            }
        });
        crew3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCrew();
            }
        });
    }

    void setUpCrews(){

    }

    void goToCrew(){
        Toast.makeText(MyCrewsActivity.this, "Hubba", Toast.LENGTH_SHORT).show();
    }
}
