package com.example.buster.mycrews.UI.Crew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

public class CrewLeaderActivity extends MenuActivity {


    FindCrewListViewAdapter CrewLeaderListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_leader);
    }
}
