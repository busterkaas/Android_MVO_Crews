package com.example.buster.mycrews.InitializeTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.UserManager;
import com.example.buster.mycrews.MainActivity;
import com.example.buster.mycrews.UI.User.MyEditProfileActivity;

import java.util.ArrayList;

/**
 * Created by Buster on 26-05-2016.
 */
public class InitializeTaskUserUpdate extends AsyncTask<
        UserManager, // collection of Users to execute
        Void, // to type of progress info
        User> // output of doInBackground
{

    MyEditProfileActivity m_context;
    User user;

    public InitializeTaskUserUpdate(MyEditProfileActivity context, User user) {
        m_context = context;
        this.user = user;
        Log.d("USERR", "TWO");
    }

    @Override
    protected User doInBackground(UserManager... ms) {
        // params comes from the execute()
        try {
            ms[0].update(user);
            return ms[0].getUpdated();
        } catch (Exception e) {
            Log.d("USERR", "TASK "+e.getMessage());
            return null;
        }
    }

    // onPostExecute displays the results of the AsyncTask.doInBackground().
// this method is invoked by the GUI thread
    @Override
    protected void onPostExecute(final User user) {
        m_context.updatedUser(user);
    }
}
