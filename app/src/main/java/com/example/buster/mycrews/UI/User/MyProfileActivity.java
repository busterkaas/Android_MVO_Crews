package com.example.buster.mycrews.UI.User;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;

public class MyProfileActivity extends MenuActivity {

    private final int CAPTURE_PICTURE_REQUEST_CODE = 100;

    private ImageView imageViewPhoto;
    private ImageButton btnTakePhoto, btnEditProfile;
    private TextView tvUsername, tvFirstname, tvLastname, tvEmail;
    private File photoFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        // Lock the screen orientation to portrait (turn-safe activity)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initComponents();

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeUserPhoto();
            }
        });
    }

    private void initComponents() {
        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        btnTakePhoto = (ImageButton) findViewById(R.id.btnTakePhoto);
        btnEditProfile = (ImageButton) findViewById(R.id.btnEditProfile);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvFirstname = (TextView) findViewById(R.id.tvFirstname);
        tvLastname = (TextView) findViewById(R.id.tvLastname);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
    }

    private void takeUserPhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Create a file to save the image
        photoFile = getOutputMediaFile();
        // Set the image file name
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_PICTURE_REQUEST_CODE && resultCode == RESULT_OK) {
            String filename = photoFile.toString();
            displayPicture(filename);
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