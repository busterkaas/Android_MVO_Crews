package com.example.buster.mycrews.UI.Crew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

public class CrewChatActivity extends MenuActivity {

    Crew crew;
    final String LOGTAG = "CrewChat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_chat);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            crew = (Crew) extra.get("crew");
            loggedInUser = (User)extra.get("LoggedInUser");

        } else {
            Log.d(LOGTAG, "crew was null");
        }

    }
}
