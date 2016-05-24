package com.example.buster.mycrews.UI.Crew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.buster.mycrews.BE.CrewGameSuggestion;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

import java.util.ArrayList;

public class CrewGamesActivity extends MenuActivity {

    ListView listView;

    ArrayList<CrewGameSuggestion> gameSugs;
    CrewGameSuggestionGameListViewAdapter crewGameSuggestionGameListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_games);

        listView = (ListView) findViewById(R.id.crewGameList);

        gameSugs = new ArrayList<>();
    }

    public void populateGameList(){

    }
}
