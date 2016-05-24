package com.example.buster.mycrews.UI.User;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.CrewManager;
import com.example.buster.mycrews.BLL.Manager.UserManager;
import com.example.buster.mycrews.Controller.UserController;
import com.example.buster.mycrews.InitializeTasks.InitializeTaskUserCrews;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

import java.util.ArrayList;

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

    CrewManager crewManager;
    UserController userController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_crews);

        userController = UserController.getInstance();

        crewManager = CrewManager.getInstance();
        loadMyCrews();

        crew1 = (LinearLayout) findViewById(R.id.crew1);
        crewName1 = (TextView) findViewById(R.id.crewName1);
        crewImage1 = (ImageView) findViewById(R.id.crewImage1);

        crew2 = (LinearLayout) findViewById(R.id.crew2);
        crewName2 = (TextView) findViewById(R.id.crewName2);
        crewImage2 = (ImageView) findViewById(R.id.crewImage2);

        crew3 = (LinearLayout) findViewById(R.id.crew3);
        crewName3 = (TextView) findViewById(R.id.crewName3);
        crewImage3 = (ImageView) findViewById(R.id.crewImage3);



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

    void loadMyCrews(){
        InitializeTaskUserCrews task = new InitializeTaskUserCrews(this, userController.getCurrentUser().getId());
        task.execute(crewManager);
    }




    void goToCrew(){
        Toast.makeText(MyCrewsActivity.this, "Hubba", Toast.LENGTH_SHORT).show();
    }

    public void instantiateUserCrews(ArrayList<Crew> crews) {

    }
}
