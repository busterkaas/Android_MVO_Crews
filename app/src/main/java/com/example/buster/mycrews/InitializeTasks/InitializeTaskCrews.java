package com.example.buster.mycrews.InitializeTasks;

import android.os.AsyncTask;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.DAL.DAL.http.CrewRepository;
import com.example.buster.mycrews.UI.Crew.FindCrewActivity;

import java.util.ArrayList;

/**
 * Created by Buster on 10-05-2016.
 */
public class InitializeTaskCrews extends AsyncTask<
        CrewRepository, // collection of PoliceDistricts to execute
        Void, // to type of progress info
        ArrayList<Crew>> // output of doInBackground
{

    FindCrewActivity m_context;

    public InitializeTaskCrews(FindCrewActivity context)
    {
        m_context = context;
    }

    @Override
    protected ArrayList<Crew> doInBackground(CrewRepository... ms) {
        // params comes from the execute()
        ms[0].loadAll();
        return ms[0].getAll();
    }

    // onPostExecute displays the results of the AsyncTask.doInBackground().
    // this method is invoked by the GUI thread
    @Override
    protected void onPostExecute(final ArrayList<Crew> crews) {
        m_context.instantiateListView(crews);
    }
}
