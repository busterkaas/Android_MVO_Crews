package com.example.buster.mycrews.DAL.DAL.http;

import android.util.Log;

import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.DAL.ICRUDRepository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Buster on 10-05-2016.
 */
public class UserRepository implements ICRUDRepository<User> {


    //private final String URL = "http://10.0.2.2:9000/api/users"; /*"http://mvogamesjs-tasin.rhcloud.com/api/users";*/

    private final String URL = "http://mvogames-hardydrachmann.rhcloud.com/api/users/";

    private final String TAG = "USER";

    ArrayList<User> m_users;
    User m_user;

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
    public void update(User user) throws Exception {
        Log.d("USERR", "FOUR");
        JSONObject userToUpdate = new JSONObject();
        try {
            userToUpdate.put("name", user.getUserName());
            userToUpdate.put("firstName", user.getFirstName());
            userToUpdate.put("lastName", user.getLastName());
            userToUpdate.put("phoneNumber", user.getPhoneNumber());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // call to async class in DAL-layer

        String JsonResponse = null;
        String JsonDATA = String.valueOf(userToUpdate);
        Log.d("USERR", "JSONDATA CREATED");
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://mvogames-hardydrachmann.rhcloud.com/api/users/" + user.getId());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            // is output buffer writer
            urlConnection.setRequestMethod("PUT");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            //set headers and method
            Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            writer.write(JsonDATA);
            // json data
            writer.close();
            InputStream inputStream = urlConnection.getInputStream();
            //input stream
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.

            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                buffer.append(inputLine + "\n");
            if (buffer.length() == 0) {
                // stream empty - nothing to parse

            }
            JsonResponse = buffer.toString();

            JSONObject jsonUser = new JSONObject(buffer.toString());
            User newUser = null;
            try {
                newUser = new User(jsonUser.getString("_id"), jsonUser.getString("name"), jsonUser.getString("firstName"), jsonUser.getString("lastName"), jsonUser.getInt("phoneNumber"));

            } catch (JSONException e) {
                Log.d(TAG, e.getMessage());
            }
            // response data
            Log.d("RESPONSE DATA",JsonResponse);
            // send to post execute
           m_user = newUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.d("USERR", "Error closing stream", e);
                }
            }
        }
    }

    @Override
    public User getUpdated() throws Exception {
        return m_user;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}
