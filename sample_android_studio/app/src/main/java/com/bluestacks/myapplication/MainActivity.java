package com.bluestacks.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gamepop.tournament.sdk.android.TSDK;
import com.gamepop.tournament.sdk.android.internal.GameData;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button postScore = (Button) findViewById(R.id.postScoreBtn);
        postScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameData gameData = new GameData();
                gameData.put("level", 1);
                gameData.put("discount", 20);

                HashMap<String, Object> userData = new HashMap<String, Object>();
                userData.put("name", "BlueStacks Dev");
                userData.put("duration_secs", 20);
                userData.put("premium", false);
                gameData.put("user_data", userData);

                TSDK.postScore(new Random().nextInt(400), gameData);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
