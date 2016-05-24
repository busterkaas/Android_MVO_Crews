package com.example.buster.mycrews.UI.Crew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.CrewGameSuggestion;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

import java.util.ArrayList;
import java.util.List;

public class CrewProfileActivity extends MenuActivity {

    Crew crew;
    String LOGTAG = "crewProfile";
    TextView crewName;
    TextView crewLeader;
    ImageView crewImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_profile);
        crewName = (TextView) findViewById(R.id.myCrewName);
        crewImage = (ImageView) findViewById(R.id.myCrewImage);
        crewLeader = (TextView) findViewById(R.id.myCrewLeader);


        Bundle extra = getIntent().getExtras();
        if(extra!=null) {
            crew = (Crew)extra.get("crew");
            setupCrewInfo();
        }else{
            Log.d(LOGTAG, "crew was null");
        }

    }

    void setupCrewInfo(){
        crewName.setText(crew.getCrewName());
        crewLeader.setText(crew.getCrewLeader().getUserName());
    }

}
