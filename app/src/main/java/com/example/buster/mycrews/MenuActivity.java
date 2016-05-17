package com.example.buster.mycrews;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.buster.mycrews.Controller.UserController;

/**
 * Created by RlxCw on 17-05-2016.
 */
public class MenuActivity extends AppCompatActivity{
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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


}
