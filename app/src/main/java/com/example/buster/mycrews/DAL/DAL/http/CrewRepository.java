package com.example.buster.mycrews.DAL.DAL.http;

import android.util.Log;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.CrewGameSuggestion;
import com.example.buster.mycrews.BE.CrewMessage;
import com.example.buster.mycrews.BE.Game;
import com.example.buster.mycrews.BE.Platform;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.DAL.ICRUDRepository;

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
public class CrewRepository implements ICRUDRepository<Crew> {

    private final String URL = "http://10.0.2.2:9000/api/crews"; /*"http://mvogamesjs-tasin.rhcloud.com/api/crews";*/

    private final String TAG = "CREW";

    ArrayList<Crew> m_crews;


    public CrewRepository() {

    }

    public void loadAll(String id) {
        m_crews = new ArrayList<Crew>();
        String result = "";
        try {
            if(id!=null){
                result = getContent(URL+ "/user/" + id);
            }else {
                result = getContent(URL);
            }
            if (result == null) return;

            JSONArray array = new JSONArray(result);
            Log.d(TAG, "loadAll: " +array);
            for (int i = 0; i < array.length(); i++) {
                JSONObject d = array.getJSONObject(i);

                String crewId = d.getString("_id");
                String crewName = d.getString("name");
                String crewImgUrl = d.getString("crewImgUrl");


                JSONObject JSONleader = d.getJSONObject("leader");

                User leader = new User(JSONleader.getString("_id"), JSONleader.getString("name"));

                JSONArray JSONApplicants = d.getJSONArray("applicants");
                ArrayList<User> applicants = new ArrayList<>();
                for (int v = 0; v < JSONApplicants.length(); v++) {
                    String userName = JSONApplicants.getJSONObject(v).getString("name");
                    String userId = JSONApplicants.getJSONObject(v).getString("_id");
                    User u = new User(userId, userName);
                    applicants.add(u);
                }

                JSONArray JSONUsers = d.getJSONArray("users");
                ArrayList<User> users = new ArrayList<>();
                for (int v = 0; v < JSONUsers.length(); v++) {
                    String userName = JSONUsers.getJSONObject(v).getString("name");
                    String userId = JSONUsers.getJSONObject(v).getString("_id");
                    User u = new User(userId, userName);
                    users.add(u);
                }

                JSONArray JSONGames = d.getJSONArray("gameSuggestions");
                ArrayList<CrewGameSuggestion> games = new ArrayList<>();
                for (int v = 0; v < JSONGames.length(); v++) {
                    String gsId = JSONGames.getJSONObject(v).getString("_id");
                    String dateString  = JSONGames.getJSONObject(v).getString("expiration");


                    JSONObject jsonGame = JSONGames.getJSONObject(v).getJSONObject("game");
                    String gameTitle = jsonGame.getString("title");
                    String gameInfo = jsonGame.getString("info");
                    String coverURL = jsonGame.getString("coverUrl");

                    Game game = new Game(gameTitle, gameInfo, coverURL);

                   JSONObject jsonPlatform = JSONGames.getJSONObject(v).getJSONObject("platform");
                    String pfName = jsonPlatform.getString("name");
                    int price = jsonPlatform.getInt("price");

                    Platform platform = new Platform(pfName, price);


                    CrewGameSuggestion cgs = new CrewGameSuggestion(gsId, 0, dateString, game, platform);

                    games.add(cgs);

                }
/*
                JSONArray JSONMessages = d.getJSONArray("crewMessages");
                ArrayList<CrewMessage> messages = new ArrayList<>();
                for (int v = 0; v < JSONUsers.length(); v++) {

                    JSONObject jsonUser = JSONMessages.getJSONObject(v).getJSONObject("user");
                    String msgUserId = jsonUser.getString("_id");
                    String msgUsername = jsonUser.getString("name");

                    User msgUser = new User(msgUserId, msgUsername);

                    String msgMessage = JSONMessages.getJSONObject(v).getString("message");

                    CrewMessage crewMessage = new CrewMessage(msgUser, msgMessage);
                    messages.add(crewMessage);

                }*/

                Crew crew = new Crew(crewId, crewName, crewImgUrl, leader, applicants, users, games);

                m_crews.add(crew);
            }

        } catch (JSONException e) {
            Log.e(TAG,
                    "There was an error parsing the JSON", e);
        } catch (Exception e) {
            Log.d(TAG, "General exception in loadAll " + e.getMessage());
        }
    }


    /**
     * Get the content of the url as a string. Based on using a scanner.
     *
     * @param urlString - the url must return data typical in either json, xml, csv etc..
     * @return the content as a string. Null is something goes wrong.
     */
    private String getContent(String urlString) {
        StringBuilder sb = new StringBuilder();
        try {
            java.net.URL url = new URL(urlString);
            Scanner s = new Scanner(url.openStream());

            while (s.hasNextLine()) {
                String line = s.nextLine();
                sb.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    @Override
    public Crew create(Crew crew) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Crew> readAll() throws Exception {
        return m_crews;
    }

    @Override
    public Crew read(int id) throws Exception {
        return null;
    }

    @Override
    public Crew update(Crew crew) throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}