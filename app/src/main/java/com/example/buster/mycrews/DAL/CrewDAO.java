package com.example.buster.mycrews.DAL;

import android.util.Log;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Buster on 10-05-2016.
 */
public class CrewDAO{

private final String URL = "http://10.0.2.2:9000/api/crews";

private final String TAG = "CREW";

ArrayList<Crew> m_crews;

        public CrewDAO(){
            m_crews = new ArrayList<Crew>();
        }

        public void loadAll()
        {
            try {
                String result = getContent(URL);

                if (result == null) return;

                JSONArray array = new JSONArray(result);

                for (int i = 0; i < array.length(); i++) {
                    JSONObject d = array.getJSONObject(i);

                        String crewId = d.getString("_id");
                        String crewName = d.getString("name");
                        String crewImgUrl = d.getString("crewImgUrl");


                        JSONObject JSONleader = d.getJSONObject("leader");
                        User leader = new User(JSONleader.getString("name"));

                        JSONArray JSONApplicants = d.getJSONArray("applicants");
                        ArrayList<User> applicants = new ArrayList<>();
                        for (int v = 0; v < JSONApplicants.length(); v++) {
                            User u = new User(JSONApplicants.getJSONObject(v).getString("name"));
                            applicants.add(u);
                        }

                        JSONArray JSONUsers = d.getJSONArray("users");
                        ArrayList<User> users = new ArrayList<>();
                        for (int v = 0; v < JSONUsers.length(); v++) {
                        User u = new User(JSONUsers.getJSONObject(v).getString("name"));
                        users.add(u);
                        }

                        Crew crew = new Crew(crewId, crewName, crewImgUrl, leader, applicants, users);

                        m_crews.add(crew);

                }

            } catch (JSONException e) {
                Log.e(TAG,
                        "There was an error parsing the JSON", e);
            } catch (Exception e)
            {  Log.d(TAG, "General exception in loadAll " + e.getMessage());
            }
        }

        public ArrayList<Crew> getAll()
        { return m_crews; }


        /**
         * Get the content of the url as a string. Based on using a scanner.
         * @param urlString - the url must return data typical in either json, xml, csv etc..
         * @return the content as a string. Null is something goes wrong.
         */
        private String getContent(String urlString)
        {
            StringBuilder sb = new StringBuilder();
            try {
                java.net.URL url = new URL(urlString);
                Scanner s = new Scanner(url.openStream());

                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    sb.append(line);
                }
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return sb.toString();
        }

}