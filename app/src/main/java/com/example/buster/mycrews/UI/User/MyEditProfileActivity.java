package com.example.buster.mycrews.UI.User;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.buster.mycrews.Controller.UserController;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

/**
 * Created by Hardy Drachmann on 17-05-2016.
 */
public class MyEditProfileActivity extends MenuActivity {

    private String loggedInUserId = UserController.getInstance().getCurrentUser().getId();
    private ImageButton btnSaveProfile;
    private EditText etUserName, etFirstName, etLastName, etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_profile);

        // Lock the screen orientation to portrait (turn-safe activity)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initComponents();
        populateEditTexts();

        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // update user in mongo database
                updateUserInDatabase();

                // update 'MyProfileActivity.class' by creating an intent and putting in the new data
                Intent sendDataBackIntent = new Intent(getApplicationContext(), MyProfileActivity.class);
                sendDataBackIntent.putExtra("userName", etUserName.getText().toString());
                sendDataBackIntent.putExtra("firstName", etFirstName.getText().toString());
                sendDataBackIntent.putExtra("lastName", etLastName.getText().toString());
                sendDataBackIntent.putExtra("phoneNumber", etPhoneNumber.getText().toString());

                // populate result and return it to 'MyProfileActivity.class
                setResult(RESULT_OK, sendDataBackIntent);
                finish();
            }
        });
    }

    private void updateUserInDatabase() {
        // go through gateway and update user in mongo database
        System.out.print("TO DO : UPDATE USER IN MONGO DATABASE");
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
}
