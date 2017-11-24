package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


public class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>> {

    @SuppressLint("StaticFieldLeak")
    private Context mContext;
    QuakeInterface quakeInterface;


    public EarthquakeAsyncTask(Context mContext, QuakeInterface quakeInterface) {
        this.mContext = mContext;
        this.quakeInterface = quakeInterface;
    }

    @Override
    protected List<Earthquake> doInBackground(String... strings) {
        String earthquakeJsonUrl = strings[0];
        URL url = null;
        try {
            url = new URL(earthquakeJsonUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            String earthquakJsonValue = readInputStreamToString(urlConnection);
            return extractEarthquakes(earthquakJsonValue);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static ArrayList<Earthquake> extractEarthquakes(String jsonString) {

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray featuresJsonArray = jsonObject.getJSONArray("features");
            Log.d("QueryUtils", featuresJsonArray.toString());
            for (int i = 0; i < featuresJsonArray.length(); i++) {
                JSONObject jsonObject1 = featuresJsonArray.getJSONObject(i);
                JSONObject jsonObject2 = jsonObject1.getJSONObject("properties");
                Log.d("QueryUtils1", jsonObject2.toString());
                String location = jsonObject2.getString("title");
                long date = jsonObject2.getLong("time");
                int magnitude = jsonObject2.getInt("mag");
                SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("LLL dd, yyyy");
                SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("h:mm a");
                Date date1 = new Date(date);
                earthquakes.add(new Earthquake(getLocation(location), simpleDateFormatDate.format(date1), magnitude, simpleDateFormatTime.format(date1), getSpeed(location)));
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return earthquakes;
    }

    private static String getSpeed(String s) {
        int index = -1;
        if (s.contains("of")) {
            index = s.indexOf("of");
        }
        if (index != -1) {
            return s.substring(0, index + 2);
        }
        return s;
    }

    private static String getLocation(String s) {
        int index = -1;
        if (s.contains("of")) {
            index = s.indexOf("of");
        }
        if (index != -1) {
            return s.substring(index + 3);
        }
        return s;
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

    @Override
    protected void onPostExecute(List<Earthquake> earthquakes) {
        super.onPostExecute(earthquakes);
        quakeInterface.data(earthquakes);

    }


}
