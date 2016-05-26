package com.example.buster.mycrews.UI.Crew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.GenerelLogic.CrewLogic;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

public class CrewProfileActivity extends MenuActivity {

    Crew crew;
    String LOGTAG = "crewProfile";

    Button btnApply;
    Button btnChat;
    Button btnGame;
    Button btnLeader;

    TextView crewName;
    TextView crewLeader;
    TextView crewMembers;
    ImageView crewImage;
    CrewLogic crewLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_profile);
        crewLogic = new CrewLogic();

        crewImage = (ImageView) findViewById(R.id.myCrewImage);
        crewName = (TextView) findViewById(R.id.myCrewName);
        crewLeader = (TextView) findViewById(R.id.myCrewLeader);
        crewMembers = (TextView) findViewById(R.id.tvCrewMembers);

        btnApply = (Button) findViewById(R.id.btnAply);
        btnChat = (Button) findViewById(R.id.btnChat);
        btnGame = (Button) findViewById(R.id.btnGameSug);
        btnLeader = (Button) findViewById(R.id.btnAdmin);


        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            crew = (Crew) extra.get("crew");
            loggedInUser = (User) extra.get("LoggedInUser");
            setupCrewInfo();
        } else {
            System.exit(0);
        }

        setupButtons();
        setupText();
    }

    private void setupText() {
        crewLeader.setText(crew.getCrewLeader().getUserName());
        int membersCount = crew.getCrewMembers().size();
        crewMembers.setText(membersCount + "/10");
    }

    void setupButtons() {

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyForMemberShip();
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(CrewChatActivity.class);
            }
        });
        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(CrewGamesActivity.class);
            }
        });
        btnLeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(CrewLeaderActivity.class);
            }
        });

        if (crewLogic.isCrewMember(crew, loggedInUser.getId())) {
            btnApply.setClickable(false);
            btnChat.setClickable(true);
            btnGame.setClickable(true);
        } else {
            btnApply.setClickable(true);
            btnChat.setClickable(false);
            btnGame.setClickable(false);
        }
        if (!crewLogic.isCrewLeader(crew, loggedInUser.getId())) {
            btnLeader.setVisibility(btnLeader.GONE);
        }
    }

    private void goToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.putExtra("crew", crew);
        intent.putExtra("LoggedInUser", loggedInUser);
        startActivity(intent);
    }

    private void applyForMemberShip() {
        Toast.makeText(this, "Applied for membership", Toast.LENGTH_SHORT).show();
    }

    void setupCrewInfo() {
        crewName.setText(crew.getCrewName());
        crewLeader.setText(crew.getCrewLeader().getUserName());
    }
}