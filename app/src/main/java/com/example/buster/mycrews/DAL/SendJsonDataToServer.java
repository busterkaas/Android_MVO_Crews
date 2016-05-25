package com.example.buster.mycrews.DAL;

import android.os.AsyncTask;
import android.util.Log;

import com.example.buster.mycrews.Controller.UserController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Hardy Drachmann on 25-05-2016.
 */
public class SendJsonDataToServer extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        String JsonResponse = null;
        String JsonDATA = params[0];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://mvogames-hardydrachmann.rhcloud.com/api/users/" + UserController.getInstance().getCurrentUser().getId());
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
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                buffer.append(inputLine + "\n");
            if (buffer.length() == 0) {
                // stream empty - nothing to parse
                return null;
            }
            JsonResponse = buffer.toString();
            // response data
            Log.d("RESPONSE DATA",JsonResponse);
            // send to post execute
            return JsonResponse;
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
                    Log.d("ERROR CLOSING READER", "Error closing stream", e);
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
    }
}
