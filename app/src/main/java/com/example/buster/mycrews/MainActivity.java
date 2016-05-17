package com.example.buster.mycrews;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.Controller.UserController;
import com.example.buster.mycrews.DAL.CrewDAO;
import com.example.buster.mycrews.DAL.UserDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserController userController;
    private ArrayList<User> users;

    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUsers();

        inputSettings();
        setImageActionBar();
    }

    void setImageActionBar(){
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowHomeEnabled(true);
        actionbar.setIcon(R.drawable.newlogo);
        actionbar.isHideOnContentScrollEnabled();
    }

    void inputSettings(){
        //Setup textfields
        etUsername = (EditText)findViewById(R.id.etLoginName);
        etPassword = (EditText)findViewById(R.id.etLoginPassword);


        //Setup login button
        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void getUsers() {
        InitializeTaskUsers taskUsers = new InitializeTaskUsers(this);
        taskUsers.execute(new UserDAO());

    }

    public void initializeUsers(ArrayList<User> users){
        Log.d("MOJN", "I was here and array is: " +users.size());
        this.users = users;
    }

    void login(){

        User user = null;
        boolean validUser = false;
        String myUsername = etUsername.getText().toString();

        for(User u : users){
            Log.d("MOJN", u.getUserName());
            if(u.getUserName().equals(myUsername)){
                user = u;
                validUser = true;

            }
        }

        //simulate login
        if(validUser){
            userController = UserController.getInstance();
            userController.userLogin(user);

            Log.d("MOJN", "My id: " +user.getId());

            Intent intent = new Intent(MainActivity.this, FindCrewActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
        }
    }


}

