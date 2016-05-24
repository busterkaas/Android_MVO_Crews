package com.example.buster.mycrews.InitializeTasks;

import android.os.AsyncTask;

import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.DAL.DAL.http.UserRepository;
import com.example.buster.mycrews.MainActivity;

import java.util.ArrayList;

/**
 * Created by Buster on 10-05-2016.
 */
public class InitializeTaskUsers extends AsyncTask<
        UserRepository, // collection of PoliceDistricts to execute
        Void, // to type of progress info
        ArrayList<User>> // output of doInBackground
{

    MainActivity m_context;

    public InitializeTaskUsers(MainActivity context)
    {
        m_context = context;
    }

    @Override
    protected ArrayList<User> doInBackground(UserRepository... ms) {
        // params comes from the execute()
        ms[0].loadAll();
        return ms[0].getAll();
    }

    // onPostExecute displays the results of the AsyncTask.doInBackground().
    // this method is invoked by the GUI thread
    @Override
    protected void onPostExecute(final ArrayList<User> users) {
        m_context.initializeUsers(users);
    }
}
