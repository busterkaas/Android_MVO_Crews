package com.example.buster.mycrews.UI.User;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyProfileActivity extends MenuActivity {


    private final int CAPTURE_PICTURE_REQUEST_CODE = 100, ACTIVITY_EDIT_PROFILE_REQUEST_CODE = 200;

    private ImageView imageViewPhoto;
    private ImageButton btnTakePhoto, btnEditProfile;
    private TextView tvUserName, tvFirstName, tvLastName, tvPhoneNumber;
    private File photoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);


        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            loggedInUser = (User) extra.get("LoggedInUser");

        } else {
            System.exit(0);
        }

        initComponents();
        populateTextViews();

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeUserPhoto();
            }
        });

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUserProfile();
            }
        });
    }

    private void initComponents() {
        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        btnTakePhoto = (ImageButton) findViewById(R.id.btnTakePhoto);
        btnEditProfile = (ImageButton) findViewById(R.id.btnEditProfile);
        tvUserName = (TextView) findViewById(R.id.tvUsername);
        tvFirstName = (TextView) findViewById(R.id.tvFirstname);
        tvLastName = (TextView) findViewById(R.id.tvLastname);
        tvPhoneNumber = (TextView) findViewById(R.id.tvPhoneNumber);
    }

    private void populateTextViews() {
        tvUserName.setText("" + loggedInUser.getUserName());
        tvFirstName.setText("" + loggedInUser.getFirstName());
        tvLastName.setText("" + loggedInUser.getLastName());
        tvPhoneNumber.setText("" + loggedInUser.getPhoneNumber());
    }

    private void editUserProfile() {
        // create intent
        Intent editUserProfileIntent = new Intent(getApplicationContext(), MyEditProfileActivity.class);
        // put extras in intent (even though we can already access 'logged in user' globally because of the static singleton class), this is just for show.
        editUserProfileIntent.putExtra("LoggedInUser", loggedInUser);
        editUserProfileIntent.putExtra("userName", tvUserName.getText());
        editUserProfileIntent.putExtra("firstName", tvFirstName.getText());
        editUserProfileIntent.putExtra("lastName", tvLastName.getText());
        editUserProfileIntent.putExtra("phoneNumber", tvPhoneNumber.getText());
        // start the intent
        startActivityForResult(editUserProfileIntent, ACTIVITY_EDIT_PROFILE_REQUEST_CODE);
    }

    private void takeUserPhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Create a file to save the image and give it a filename - SEE METHOD BELOW
        photoFile = getOutputMediaFile();

        // photo will be saved to this location with a generated name from 'photoFile'
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
        startActivityForResult(intent, CAPTURE_PICTURE_REQUEST_CODE);
    }

    // Create a file for saving an image
    private File getOutputMediaFile() {
        // Check that the SDCard is mounted
        Toast.makeText(this, Environment.MEDIA_MOUNTED, Toast.LENGTH_LONG).show();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File storagePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "mvoUserImages");
            // Create the storage path (myCamera) if it does not exist
            if (!storagePath.exists()) {
                if (!storagePath.mkdirs()) {
                    Toast.makeText(getApplicationContext(), "Failed to create 'mvoUserImages' directory on SDcard", Toast.LENGTH_SHORT).show();
                    return null;
                }
            }
            // Create a media file name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String prefix = "mvoUserImage";
            String postfix = "jpg";

            File mediaFile = new File(storagePath.getPath() + File.separator + prefix +
                    "_" + timeStamp + "." + postfix);
            return mediaFile;
        }
        Toast.makeText(getApplicationContext(), "No SDcard mounted", Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    // handle returned result from intent (CAMERA & EDIT USER PROFILE)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // handle the returned result from 'Camera intent'
        if (requestCode == CAPTURE_PICTURE_REQUEST_CODE && resultCode == RESULT_OK) {
            String filename = photoFile.toString();
            displayPicture(filename);
        }
        // handle the returned result from 'edit user profile intent'
        if (requestCode == ACTIVITY_EDIT_PROFILE_REQUEST_CODE && resultCode == RESULT_OK) {
            // update the logged in users info
            loggedInUser = (User) data.getExtras().get("user");
            loggedInUser.setUserName("" + data.getStringExtra("userName"));
            loggedInUser.setFirstName("" + data.getStringExtra("firstName"));
            loggedInUser.setLastName("" + data.getStringExtra("lastName"));
            loggedInUser.setPhoneNumber(Integer.parseInt(data.getStringExtra("phoneNumber")));

            // update textviews with data from the newly updated logged in user
            tvUserName.setText("" + loggedInUser.getUserName());
            tvFirstName.setText("" + loggedInUser.getFirstName());
            tvLastName.setText("" + loggedInUser.getLastName());
            tvPhoneNumber.setText("" + loggedInUser.getPhoneNumber());
        }
    }

    private void displayPicture(String filename) {
        File myUserPhoto = new File(filename);
        if (!myUserPhoto.exists()) {
            Toast.makeText(getApplicationContext(), "File does not exist", Toast.LENGTH_SHORT).show();
        }
        // Display the image
        imageViewPhoto.setImageURI(Uri.fromFile(myUserPhoto));
    }
}