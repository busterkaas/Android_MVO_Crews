package com.example.buster.mycrews.UI.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BLL.Manager.CrewManager;
import com.example.buster.mycrews.Controller.UserController;
import com.example.buster.mycrews.InitializeTasks.InitializeTaskUserCrews;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;
import com.example.buster.mycrews.UI.Crew.CrewProfileActivity;
import com.example.buster.mycrews.UI.Crew.FindCrewActivity;

import java.util.ArrayList;

public class MyCrewsActivity extends MenuActivity {

    LinearLayout crew1;
    TextView crewName1;
    ImageView crewImage1;
    LinearLayout crew2;
    TextView crewName2;
    ImageView crewImage2;
    ArrayList<ImageView> imageViews = new ArrayList<>();
    ArrayList<TextView> textViews = new ArrayList<>();
    ArrayList<Crew> crews;
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


        textViews.add(crewName1);
        textViews.add(crewName2);
        textViews.add(crewName3);

        imageViews.add(crewImage1);
        imageViews.add(crewImage2);
        imageViews.add(crewImage3);

        crew1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCrew(0);
            }
        });
        crew2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCrew(1);
            }
        });
        crew3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCrew(2);
            }
        });
    }

    void loadMyCrews(){
        InitializeTaskUserCrews task = new InitializeTaskUserCrews(this, userController.getCurrentUser().getId());
        task.execute(crewManager);
    }

    void goToCrew(int crew){
        Intent intent;
        if(crews.size()>= crew+1) {
            intent = new Intent(MyCrewsActivity.this, CrewProfileActivity.class);
            intent.putExtra("crew", crews.get(crew));
            startActivity(intent);
        }else{
            intent = new Intent(MyCrewsActivity.this, FindCrewActivity.class);
            startActivity(intent);
        }
    }


    public void instantiateUserCrews(ArrayList<Crew> crews) {
        this.crews = crews;
        for (int i = 0; i < crews.size(); i++){
                textViews.get(i).setText(crews.get(i).getCrewName());
                downloadImage(imageViews.get(i), crews.get(i).getCrewImgUrl());

        }
    }
}
