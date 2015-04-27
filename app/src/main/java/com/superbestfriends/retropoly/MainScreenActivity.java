package com.superbestfriends.retropoly;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainScreenActivity extends ActionBarActivity {
    int randInt;
    MediaPlayer mediaPlayer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        playBack();


        SharedPreferences settings = getSharedPreferences(SettingsActivity.PREFS_NAME, 0);
        //Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);
        if (!hasLoggedIn) {
            // Here we start the next activity, and then call finish()
            // so that our own will stop running and be removed from the
            // history stack
            Intent intent = new Intent();
            intent.setClass(MainScreenActivity.this, LoginActivity.class);
            startActivity(intent);
            MainScreenActivity.this.finish();
        }
        Button dice = (Button) findViewById(R.id.die);
        dice.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                randInt = new Random().nextDouble() < 0.5 ? 1 : 2;
                System.out.println(randInt);

            }
        }


            );

        TextView dieRoll = (TextView) findViewById(R.id.dieRoll);
        dieRoll.setText(randInt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    private void playBack(){

        mediaPlayer = MediaPlayer.create(this, R.raw.Third_Time);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        } else if (id == R.id.action_sign_out) {
            SharedPreferences settings = getSharedPreferences(SettingsActivity.PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("hasLoggedIn", false);
            editor.commit();
            // restart app
            Intent i = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage(getBaseContext().getPackageName());
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        } else if (id == R.id.action_new_game) {
            Intent i = new Intent(this, CreateGameActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_screen, container, false);
            return rootView;
        }
    }
}
