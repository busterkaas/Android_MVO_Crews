package com.example.buster.mycrews;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.ImageDownloader;
import com.example.buster.mycrews.UI.Crew.FindCrewActivity;
import com.example.buster.mycrews.UI.User.MyCrewsActivity;
import com.example.buster.mycrews.UI.User.MyProfileActivity;

/**
 * Created by RlxCw on 17-05-2016.
 */
public class MenuActivity extends AppCompatActivity{

    public User user;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setImageActionBar();
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    void setImageActionBar(){
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowHomeEnabled(true);
        actionbar.setIcon(R.drawable.newlogo);
        actionbar.isHideOnContentScrollEnabled();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.myProfile) {
            Intent intent = new Intent(MenuActivity.this, MyProfileActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.myCrews) {
            Intent intent = new Intent(MenuActivity.this, MyCrewsActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.allCrews) {
            Intent intent = new Intent(MenuActivity.this, FindCrewActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.logout) {
            Intent intent = new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToActivity(Class goToActivity, Crew crew){

        Intent intent = new Intent(getApplicationContext(), goToActivity);
        if(crew!=null){
            intent.putExtra("crew", crew);
        }
        intent.putExtra("LoggedInUser", user);
        startActivity(intent);
    }

    public void setUser(User user){
        this.user = user;
    }


    public void downloadImage(ImageView imgView, String url) {

        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;
        try {
            myImage = task.execute(url).get();
            imgView.setImageBitmap(myImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        user = null;
    }
}
