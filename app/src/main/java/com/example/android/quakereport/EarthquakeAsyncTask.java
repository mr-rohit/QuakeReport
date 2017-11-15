/*
package com.example.android.quakereport;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


public class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>> {

    Context mContext;

    public EarthquakeAsyncTask(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected List<Earthquake> doInBackground(String... strings) {
        String earthquakeJsonUrl = strings[0];
        URL url = null;
        try {
            url = new URL(earthquakeJsonUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            String earthquakJsonValue = readInputStreamToString(urlConnection);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String readInputStreamToString(HttpsURLConnection httpsURLConnection) {
        InputStream inputStream = null;
        String result = null;
        StringBuilder stringBuffer = new StringBuilder();
        try {
            inputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine = "";
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            result = stringBuffer.toString();
        } catch (IOException e) {
            Toast.makeText(mContext, "Error reading InputSTream", Toast.LENGTH_SHORT).show();
            result = null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Toast.makeText(mContext, "Error closing InputStream", Toast.LENGTH_SHORT).show();
                }
            }
        }
        return result;
    }
}
*/
