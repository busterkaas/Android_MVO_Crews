package com.example.buster.mycrews.UI.Crew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

public class CrewProfileActivity extends MenuActivity {

    Crew crew;
    String LOGTAG = "crewProfile";
    TextView crewName;
    ImageView crewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_profile);
        crewName = (TextView) findViewById(R.id.myCrewName);
        crewImage = (ImageView) findViewById(R.id.myCrewImage);

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
    }
}
