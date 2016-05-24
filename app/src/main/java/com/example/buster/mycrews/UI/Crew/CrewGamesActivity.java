package com.example.buster.mycrews.UI.Crew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.CrewGameSuggestion;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

import java.util.ArrayList;

public class CrewGamesActivity extends MenuActivity {

    CrewGameSuggestionGameListViewAdapter CGSListViewAdapter;
    ListView listView;
    Crew crew;

    private final String LOGTAG = "CrewGames";

    ArrayList<CrewGameSuggestion> gameSugs;
    CrewGameSuggestionGameListViewAdapter crewGameSuggestionGameListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_games);

        listView = (ListView) findViewById(R.id.crewGameList);
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            crew = (Crew) extra.get("crew");

        } else {
            Log.d(LOGTAG, "crew was null");
        }

        gameSugs = crew.getCrewGameSuggestions();

        setupList();
    }

    private void setupList() {
        //setup adapter
        CGSListViewAdapter = new CrewGameSuggestionGameListViewAdapter(getApplicationContext(), gameSugs);
        listView.setAdapter(CGSListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), gameSugs.get(position).getGame().getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void populateGameList() {

    }
}
