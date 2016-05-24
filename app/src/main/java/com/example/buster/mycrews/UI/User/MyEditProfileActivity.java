package com.example.buster.mycrews.UI.User;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.buster.mycrews.R;

/**
 * Created by Hardy Drachmann on 17-05-2016.
 */
public class MyEditProfileActivity extends AppCompatActivity {

    private ImageButton btnSaveProfile;
    private EditText etUsername, etFirstname, etLastname, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        // Lock the screen orientation to portrait (turn-safe activity)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initComponents();

    }

    private void initComponents() {
        btnSaveProfile = (ImageButton) findViewById(R.id.btnSaveProfile);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etFirstname = (EditText) findViewById(R.id.etFirstname);
        etLastname = (EditText) findViewById(R.id.etLastname);
        etEmail = (EditText) findViewById(R.id.etEmail);
    }
}
