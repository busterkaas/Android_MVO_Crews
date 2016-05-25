package com.example.buster.mycrews.InitializeTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.UserManager;
import com.example.buster.mycrews.DAL.DAL.http.UserRepository;
import com.example.buster.mycrews.MainActivity;

import java.util.ArrayList;

/**
 * Created by Buster on 10-05-2016.
 */
public class InitializeTaskUsers extends AsyncTask<
        UserManager, // collection of Users to execute
        Void, // to type of progress info
        ArrayList<User>> // output of doInBackground
{

    MainActivity m_context;

    public InitializeTaskUsers(MainActivity context)
    {
        m_context = context;
    }

    @Override
    protected ArrayList<User> doInBackground(UserManager... ms) {
        // params comes from the execute()
        try {
            ms[0].loadAll(null);
            return ms[0].getAll();
        }catch (Exception e){
            Log.d("error", "error here");
            return null;
        }
    }

    // onPostExecute displays the results of the AsyncTask.doInBackground().
    // this method is invoked by the GUI thread
    @Override
    protected void onPostExecute(final ArrayList<User> users) {
        m_context.initializeUsers(users);
    }
}
