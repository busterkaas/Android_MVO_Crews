package com.example.buster.mycrews.UI.User;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

public class MyCrewsActivity extends MenuActivity {

    LinearLayout crew1;
    TextView crewName1;
    ImageView crewImage1;

    LinearLayout crew2;
    TextView crewName2;
    ImageView crewImage2;

    LinearLayout crew3;
    TextView crewName3;
    ImageView crewImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_crews);

        crew1 = (LinearLayout) findViewById(R.id.crew1);
        crewName1 = (TextView) findViewById(R.id.crewName1);
        crewImage1 = (ImageView) findViewById(R.id.crewImage1);

        crew2 = (LinearLayout) findViewById(R.id.crew2);
        crewName2 = (TextView) findViewById(R.id.crewName2);
        crewImage2 = (ImageView) findViewById(R.id.crewImage2);

        crew3 = (LinearLayout) findViewById(R.id.crew3);
        crewName3 = (TextView) findViewById(R.id.crewName3);
        crewImage3 = (ImageView) findViewById(R.id.crewImage3);

        setUpCrews();

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
