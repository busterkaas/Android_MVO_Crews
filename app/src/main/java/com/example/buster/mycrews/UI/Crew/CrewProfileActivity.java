package com.example.buster.mycrews.UI.Crew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.CrewGameSuggestion;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.GenerelLogic.CrewLogic;
import com.example.buster.mycrews.Controller.UserController;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

import java.util.ArrayList;
import java.util.List;

public class CrewProfileActivity extends MenuActivity {

    Crew crew;
    UserController userController;
    User me;
    String LOGTAG = "crewProfile";
    Button btnApply;

    TextView crewName;
    TextView crewLeader;
    ImageView crewImage;
    CrewLogic crewLogic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_profile);
        userController = UserController.getInstance();
        me = userController.getCurrentUser();
       crewLogic = new CrewLogic();

        crewName = (TextView) findViewById(R.id.myCrewName);
        crewImage = (ImageView) findViewById(R.id.myCrewImage);
        crewLeader = (TextView) findViewById(R.id.myCrewLeader);
        btnApply = (Button) findViewById(R.id.btnAply);





        Bundle extra = getIntent().getExtras();
        if(extra!=null) {
            crew = (Crew)extra.get("crew");
            setupCrewInfo();
        }else{
            Log.d(LOGTAG, "crew was null");
        }



        setupButtons();

    }
    void setupButtons(){

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyForMemberShip();
            }
        });

        if(crewLogic.isCrewMember(crew, me.getId())){
                btnApply.setClickable(false);
        }else {
            btnApply.setClickable(true);

        }
    }

    private void applyForMemberShip() {
        Toast.makeText(this, "Lort", Toast.LENGTH_SHORT).show();
    }

    void setupCrewInfo(){
        crewName.setText(crew.getCrewName());
        crewLeader.setText(crew.getCrewLeader().getUserName());


    }

}
