package com.example.buster.mycrews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.UserManager;
import com.example.buster.mycrews.InitializeTasks.InitializeTaskUsers;
import com.example.buster.mycrews.UI.User.MyProfileActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    User userLogin = null;
    private ArrayList<User> users;
    UserManager userManager;

    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userManager = UserManager.getInstance();
        getUsers();

        inputSettings();
        setImageActionBar();
    }

    void setImageActionBar() {
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowHomeEnabled(true);
        actionbar.setIcon(R.drawable.newlogo);
        actionbar.isHideOnContentScrollEnabled();
    }

    void inputSettings() {
        //Setup textfields
        etUsername = (EditText) findViewById(R.id.etLoginName);
        etPassword = (EditText) findViewById(R.id.etLoginPassword);


        //Setup login button
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUsers();
        userLogin = null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getUsers();
        userLogin = null;
    }

    public void getUsers() {
        InitializeTaskUsers taskUsers = new InitializeTaskUsers(this);
        taskUsers.execute(userManager);
    }

    public void initializeUsers(ArrayList<User> users) {
        this.users = users;
    }

    void login() {

        boolean validUser = false;
        String myUsername = etUsername.getText().toString();

        for (User u : users) {
            if (u.getUserName().equals(myUsername)) {
                userLogin = u;
                validUser = true;
            }
        }

        //simulate login
        if (validUser) {

            Intent intent = new Intent(MainActivity.this, MyProfileActivity.class);
            intent.putExtra("LoggedInUser", userLogin);

            startActivity(intent);


            /*
            userController = UserController.getInstance();
            userController.userLogin(user);


            Log.d("MOJN", "My id: " + user.getId());

            Intent intent = new Intent(MainActivity.this, FindCrewActivity.class);
            startActivity(intent);
            */
        } else {
            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
        }
    }
}