package com.example.buster.mycrews;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.buster.mycrews.Controller.UserController;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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
        // create a new json object with the updated information
        JSONObject updatedUser = new JSONObject();
        try {
            updatedUser.put("_id", "" + loggedInUserId);
            updatedUser.put("name", "" + etUserName.getText().toString());
            updatedUser.put("firstName", "" + etFirstName.getText().toString());
            updatedUser.put("lastName", "" + etLastName.getText().toString());
            updatedUser.put("phoneNumber", "" + Integer.parseInt(etPhoneNumber.getText().toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        URL urlToRequest;
        String urlPath = "http://localhost:9000/api/users/" + loggedInUserId;
        HttpURLConnection urlConnection = null;
        try {
            urlToRequest = new URL(urlPath);
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("PUT");
            urlConnection.setRequestProperty("Content-Type", "application/json");
        } catch (ProtocolException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(urlConnection.getOutputStream());
            System.out.println("" + updatedUser.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (out != null) {
            out.print(updatedUser);
        }
        out.close();
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
