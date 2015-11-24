package com.ps.comunio.comuniops;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Hawk on 24/11/2015.
 */
public class MyConnection extends AsyncTask<Void,Void,Void>{



        protected void onPreExecute() {
        //display progress dialog.

    }
    protected Void doInBackground(Void... params) {
        URL url = null;
        try {
            url = new URL("http://www.google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        con.setDoOutput(true);
        try {
            String responseMsg = con.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            int response = con.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected void onPostExecute(Void result) {
        // dismiss progress dialog and update ui
    }
}
