package project.hackthenorth.com.hackthenorth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;


import java.sql.SQLOutput;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText inputWorkOutTime, inputRestTime, inputCycleTime;
    Button plusButtonForWorkOutTime, plusButtonForRestTime, minusButtonForWorkOutTime, minusButtonForRestTime, plusCycle, minusCycle;
    int menuIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Navigation Bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.menu_workout:
                                selectedFragment = WorkoutFragment.newInstance();
                                menuIndex = 0;
                                break;
                            case R.id.menu_preferences:
                                selectedFragment = PreferencesFragment.newInstance();
                                menuIndex = 1;
                                break;
                            case R.id.menu_analytics:
                                selectedFragment = AnalyticsFragment.newInstance();
                                menuIndex = 2;
                                break;
                            case R.id.menu_settings:
                                selectedFragment = SettingsFragment.newInstance();
                                menuIndex = 3;
                                break;
                        }
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_layout, WorkoutFragment.newInstance());
                            transaction.commit();


                        return true;
                    }
                });





    }
}
