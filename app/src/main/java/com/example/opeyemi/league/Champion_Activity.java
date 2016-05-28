package com.example.opeyemi.league;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Champion_Activity extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView championListView = (ListView)findViewById(R.id.championListView);
        final ArrayList<Champion> champions = new ArrayList<>();
        final Adapter adapter = new Adapter(this, champions);

        championListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent overviewPageIntent = new Intent(Champion_Activity.this, Overview_Activity.class);
                startActivity(overviewPageIntent);
            }
        });


        championListView.setAdapter(adapter);

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    String championIds = Champion_Activity.this.run("https://euw.api.pvp.net/api/lol/euw/v1.2/champion?api_key=d572d57f-7126-490a-ad90-8bc382943e9c");
                    JSONObject jObject = new JSONObject(championIds);
                    JSONArray jsonArray = jObject.getJSONArray("champions");
                    for(int i=0; i<jsonArray.length(); i++){

                        JSONObject championObject = jsonArray.getJSONObject(i);
                        int id = championObject.getInt("id");
                        String championText = Champion_Activity.this.run("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+id+"?champData=image,lore&api_key=d572d57f-7126-490a-ad90-8bc382943e9c");
                        JSONObject championJson = new JSONObject(championText);
                        Champion champion = new Champion(championJson.getString("name"), championJson.getString("lore"),
                                                       "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/"+championJson.getString("name")+"_0.jpg");
                        champions.add(champion);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });


                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();




    }


    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_champion_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
