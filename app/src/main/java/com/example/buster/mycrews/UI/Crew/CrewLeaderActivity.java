package com.example.buster.mycrews.UI.Crew;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;
import com.example.buster.mycrews.UI.ListViewAdapters.CrewLeaderListViewAdapter;

import java.util.ArrayList;

public class CrewLeaderActivity extends MenuActivity {

    private final String LOGTAG = "CrewLeaderActivity";

    CrewLeaderListViewAdapter crewLeaderListViewAdapter;
    ListView listView;
    TextView whatToSee;
    Button btnUsers;
    Button btnApplicants;

    ArrayList<User> users;
    boolean isMembers;

    Crew crew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_leader);

        listView = (ListView) findViewById(R.id.usersList);
        btnUsers = (Button) findViewById(R.id.btnShowUsers);
        btnApplicants = (Button) findViewById(R.id.btnShowApplicants);
        whatToSee = (TextView) findViewById(R.id.txtWhatToSee);

        users = new ArrayList<>();


        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            crew = (Crew) extra.get("crew");

        } else {
            Log.d(LOGTAG, "crew was null");
        }

        setupButtons();
        setupList();

    }

    private void setupButtons() {
        btnApplicants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users = crew.getCrewApplicants();
                whatToSee.setText("Crew applicants");
                updateList(false);
            }
        });

        btnUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users = crew.getCrewMembers();
                whatToSee.setText("Crew members");
                updateList(true);
            }
        });
    }

    private void updateList(boolean isMember) {
        crewLeaderListViewAdapter.setMember(isMember);
        crewLeaderListViewAdapter.setUsers(users);
        crewLeaderListViewAdapter.notifyDataSetChanged();
    }

    private void setupList() {
        //setup adapter
        crewLeaderListViewAdapter = new CrewLeaderListViewAdapter(getApplicationContext(), users, isMembers);
        listView.setAdapter(crewLeaderListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), users.get(position).getUserName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
