package com.example.buster.mycrews.UI.Crew;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.CrewManager;
import com.example.buster.mycrews.InitializeTasks.InitializeTaskCrews;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;
import com.example.buster.mycrews.UI.ListViewAdapters.FindCrewListViewAdapter;

import java.util.ArrayList;

public class FindCrewActivity extends MenuActivity {

    ListView listView;
    EditText etSearchField;

    ArrayList<Crew> crews;
    ArrayList<Crew> crewSearch;

    FindCrewListViewAdapter findCrewListViewAdapter;

    CrewManager crewManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_crew);



        Bundle extra = getIntent().getExtras();
        if(extra!=null) {
            loggedInUser = (User)extra.get("LoggedInUser");
        }else{
            System.exit(0);
        }

        crewManager = CrewManager.getInstance();

        listView = (ListView) findViewById(R.id.crewList);
        etSearchField = (EditText) findViewById(R.id.etCrewSearch);
        etSearchField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                seachCrewsList();
                return false;
            }
        });


        crews = new ArrayList<>();
        InitializeTaskCrews tast = new InitializeTaskCrews(this, null);
        tast.execute(crewManager);


    }

    private void seachCrewsList(){
        crewSearch = new ArrayList<>();
        String search = etSearchField.getText().toString();
        for(Crew c : crews){
            if(c.getCrewName().contains(search)){
                crewSearch.add(c);
            }
        }
        findCrewListViewAdapter.searchCrewList(crewSearch);
        findCrewListViewAdapter.notifyDataSetChanged();
    }



    private void crewDetails(int pos){
        Intent intent = new Intent(FindCrewActivity.this, CrewProfileActivity.class);
        Crew crew = crewSearch.get(pos);
        intent.putExtra("crew", crew);
        intent.putExtra("LoggedInUser", loggedInUser);
        startActivity(intent);
    }

    public void instantiateListView(ArrayList<Crew> crews){

        this.crews = crews;
        crewSearch = crews;

        //setup adapter
        findCrewListViewAdapter = new FindCrewListViewAdapter(getApplicationContext(),crews);
        listView.setAdapter(findCrewListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                crewDetails(position);
            }
        });

    }



}


