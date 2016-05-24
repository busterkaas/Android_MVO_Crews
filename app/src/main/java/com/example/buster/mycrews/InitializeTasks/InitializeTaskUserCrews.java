package com.example.buster.mycrews.InitializeTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BLL.Manager.CrewManager;
import com.example.buster.mycrews.UI.Crew.FindCrewActivity;
import com.example.buster.mycrews.UI.User.MyCrewsActivity;

import java.util.ArrayList;

/**
 * Created by Buster on 24-05-2016.
 */
public class InitializeTaskUserCrews extends AsyncTask<
        CrewManager, // collection of Crews to execute
        Void, // to type of progress info
        ArrayList<Crew>> // output of doInBackground
{

    MyCrewsActivity m_context;
    String userId;

    public InitializeTaskUserCrews(MyCrewsActivity context, String userId)
    {
        m_context = context;
        this.userId = userId;
    }

    @Override
    protected ArrayList<Crew> doInBackground(CrewManager... ms) {
        // params comes from the execute()
        try {
            ms[0].loadAllUserCrews(userId);
            return ms[0].readAllUserCrews();
        }catch (Exception e){
            return null;
        }
    }

    // onPostExecute displays the results of the AsyncTask.doInBackground().
    // this method is invoked by the GUI thread
    @Override
    protected void onPostExecute(final ArrayList<Crew> crews) {
        m_context.instantiateUserCrews(crews);
        Log.d("CREWSIZE", "Size: "+ crews.size());
    }
}
