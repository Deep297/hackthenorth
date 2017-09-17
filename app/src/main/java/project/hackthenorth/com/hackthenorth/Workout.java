package project.hackthenorth.com.hackthenorth;

import android.os.SystemClock;
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

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.hello);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.beep);
        Bundle bundle = getIntent().getExtras();
        String work = bundle.getString("Work");
        String rest = bundle.getString("Rest");

        if(work.equals("") || rest.equals("")){}
        else {
            int x = (Integer.valueOf(work)) * 1000;
            int y = (Integer.valueOf(rest)) * 1000;


       mp.start();

        for(int i = 0; i < 5; i++){

            timer(x);
            mp1.start();

            timer(y);
            mp.start();
    }}}

    public void timer (int time){

        SystemClock.sleep(time);
        return;
    }

}











