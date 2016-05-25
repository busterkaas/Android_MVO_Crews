package com.example.buster.mycrews.DAL.DAL.http;

import android.util.Log;

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
public class UserRepository implements ICRUDRepository<User> {

    private final String URL = "http://mvogamesjs-tasin.rhcloud.com/api/users";

    private final String TAG = "USER";

    ArrayList<User> m_users;

    public UserRepository() {
        m_users = new ArrayList<User>();
    }

    public void loadAll(String userId) {
        try {
            String result = getContent(URL);

            if (result == null) return;

            JSONArray array = new JSONArray(result);
            Log.d(TAG, "loadAll: " + array);
            for (int i = 0; i < array.length(); i++) {
                JSONObject d = array.getJSONObject(i);
                try {
                    User user = new User(d.getString("_id"), d.getString("name"), d.getString("firstName"), d.getString("lastName"), d.getInt("phoneNumber"));
                    m_users.add(user);
                } catch (JSONException e) {
                    Log.d(TAG, e.getMessage());
                }
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
    public User create(User user) throws Exception {
        return null;
    }

    @Override
    public ArrayList<User> readAll() throws Exception {
        return m_users;
    }

    @Override
    public User read(int id) throws Exception {
        return null;
    }

    @Override
    public User update(User user) throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}
