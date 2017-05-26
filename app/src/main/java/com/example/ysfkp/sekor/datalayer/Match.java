package com.example.ysfkp.sekor.datalayer;

import android.widget.Toast;

import com.example.ysfkp.sekor.App;
import com.example.ysfkp.sekor.R;
import com.example.ysfkp.sekor.entity.MatchResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ysfkp on 18/05/17.
 */

public class Match {
    private String date;
    private String competitionId;
    OkHttpClient client;
    String url = "https://api.crowdscores.com/v1/matches?";

    public Match(String date, String competitionId) {
        this.date = date;
        this.competitionId = competitionId;
        client = new OkHttpClient();

    }

    public List<MatchResult> getResult() {
        String api_key = App.getContext().getResources().getString(R.string.api_key);

        String requestUrl = url + "api_key="+api_key+
                "&competition_id="+competitionId+
                "&from="+date;
        Request request = new Request.Builder().url(requestUrl).build();

        JSONArray result = null;
        try {
            Response response = client.newCall(request).execute();
            result = new JSONArray(response.body().string());
        } catch (IOException e) {
            //e.printStackTrace();
            try {
                result = new JSONArray("[]");
            } catch (JSONException e1) {
                //e1.printStackTrace();
            }
        } catch (JSONException e) {
            //e.printStackTrace();
            try {
                result = new JSONArray("[]");
            } catch (JSONException e1) {
                //e1.printStackTrace();
            }
        }

        ArrayList<MatchResult> results = new ArrayList<>();

        for (int i=0; i < result.length(); i++) {
            try {
                JSONObject resultItem = result.getJSONObject(i);
                String team1 = resultItem.getJSONObject("homeTeam").getString("name");
                String score1 = resultItem.getString("homeGoals");
                String team2 = resultItem.getJSONObject("awayTeam").getString("name");
                String score2 = resultItem.getString("awayGoals");
                results.add(new MatchResult(team1, score1, team2, score2));
            } catch (JSONException e) {
                //e.printStackTrace();
            }

        }

        return results;
    }

}
