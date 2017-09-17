package project.hackthenorth.com.hackthenorth;

import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import android.widget.TextView;


public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        final MediaPlayer begin = MediaPlayer.create(this, R.raw.begin);
        final MediaPlayer resume = MediaPlayer.create(this, R.raw.resume);
        final MediaPlayer complete = MediaPlayer.create(this, R.raw.complete);
        final MediaPlayer restup = MediaPlayer.create(this, R.raw.rest);
        final MediaPlayer song = MediaPlayer.create(this, R.raw. jumpman)
;
        Bundle bundle = getIntent().getExtras();
        String work = bundle.getString("Work");
        String rest = bundle.getString("Rest");
        String cycles = bundle.getString("Cycles");

        if(work.equals("") || rest.equals("")){}
        else {
            int x = (Integer.valueOf(work)) * 1000;
            int y = (Integer.valueOf(rest)) * 1000;


       begin.start();

        for(int i = 0; i < Integer.valueOf(cycles); i++){

            timer(x);
            restup.start();

            timer(y);
            resume.start();
        }
        complete.start();
            song.start();

        }}

    public void timer (int time){
        SystemClock.sleep(time);
        return;
    }

}











