package com.example.buster.mycrews.UI.User;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.UserManager;
import com.example.buster.mycrews.InitializeTasks.InitializeTaskUserUpdate;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

/**
 * Created by Hardy Drachmann on 17-05-2016.
 */
public class MyEditProfileActivity extends MenuActivity {

    //private String loggedInUserId = UserController.getInstance().getCurrentUser().getId();
    private ImageButton btnSaveProfile;
    private EditText etUserName, etFirstName, etLastName, etPhoneNumber;

    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_profile);
        userManager = UserManager.getInstance();

        Bundle extra = getIntent().getExtras();
        if(extra!=null) {
            loggedInUser = (User)extra.get("LoggedInUser");
        }else{
            System.exit(0);
        }

        // Lock the screen orientation to portrait (turn-safe activity)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initComponents();
        populateEditTexts();

        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // update user in mongo database
                updateUserInDatabase();
            }
        });
    }

    private void updateUserInDatabase() {
        User userToUpdate;
        String id = loggedInUser.getId();
        String username = etUserName.getText().toString();
        String firstname = etFirstName.getText().toString();
        String lastname = etLastName.getText().toString();
        int phone = Integer.parseInt(etPhoneNumber.getText().toString());

        userToUpdate = new User(id, username, firstname, lastname, phone);
        Log.d("USERR", "ONE");
        InitializeTaskUserUpdate task = new InitializeTaskUserUpdate(this, userToUpdate);
        task.execute(userManager);

    }



    private void populateEditTexts() {
        etUserName.setText(getIntent().getStringExtra("userName"));
        etFirstName.setText(getIntent().getStringExtra("firstName"));
        etLastName.setText(getIntent().getStringExtra("lastName"));
        etPhoneNumber.setText(getIntent().getStringExtra("phoneNumber"));
    }

    private void initComponents() {
        btnSaveProfile = (ImageButton) findViewById(R.id.btnSaveProfile);
        etUserName = (EditText) findViewById(R.id.etUsername);
        etFirstName = (EditText) findViewById(R.id.etFirstname);
        etLastName = (EditText) findViewById(R.id.etLastname);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
    }

    public void updatedUser(User user) {
        loggedInUser = user;
        // update 'MyProfileActivity.class' by creating an intent and putting in the new data
        Intent sendDataBackIntent = new Intent(getApplicationContext(), MyProfileActivity.class);
        sendDataBackIntent.putExtra("user", loggedInUser);
        sendDataBackIntent.putExtra("userName", loggedInUser.getUserName());
        sendDataBackIntent.putExtra("firstName", loggedInUser.getFirstName());
        sendDataBackIntent.putExtra("lastName", loggedInUser.getLastName());
        sendDataBackIntent.putExtra("phoneNumber", String.valueOf(loggedInUser.getPhoneNumber()));

        // populate result and return it to 'MyProfileActivity.class

       setResult(RESULT_OK, sendDataBackIntent);

        finish();

    }
}
