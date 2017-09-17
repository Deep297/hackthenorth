package project.hackthenorth.com.hackthenorth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    EditText inputWorkOutTime, inputRestTime;
    Button plusButtonForWorkOutTime, plusButtonForRestTime, minusButtonForWorkOutTime, minusButtonForRestTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputWorkOutTime = (EditText)findViewById(R.id.inputWorkOutTime);
        inputRestTime = (EditText)findViewById(R.id.inputRestTime);

        plusButtonForRestTime = (Button)findViewById(R.id.plusButtonForRest);
        plusButtonForWorkOutTime = (Button)findViewById(R.id.plusButtonForWorkOut);
        minusButtonForRestTime = (Button)findViewById(R.id.minusButtonForRest);
        minusButtonForWorkOutTime = (Button)findViewById(R.id.minusButtonForWorkOut);

        if (inputWorkOutTime.getText().toString().equals("0")||inputRestTime.getText().toString().equals("0")){
            Toast.makeText(MainActivity.this, "Invalid Time!", Toast.LENGTH_LONG).show();

        }

        plusButtonForWorkOutTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputWorkOutTime.getText().toString().equals("")){
                    inputWorkOutTime.setText("0");
                    int workOutTime = Integer.valueOf(inputWorkOutTime.getText().toString());
                    workOutTime = workOutTime+5;
                    inputWorkOutTime.setText(Integer.toString(workOutTime));

                }
                else {
                    int workOutTime = Integer.valueOf(inputWorkOutTime.getText().toString());
                    workOutTime = workOutTime+5;
                    inputWorkOutTime.setText(Integer.toString(workOutTime));
                }
            }
        });

        plusButtonForRestTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputRestTime.getText().toString().equals("")){
                    inputRestTime.setText("0");
                    int restTime = Integer.valueOf(inputRestTime.getText().toString());
                    restTime= restTime+5;
                    inputRestTime.setText(Integer.toString(restTime));

                }
                else {
                    int restTime = Integer.valueOf(inputRestTime.getText().toString());
                     restTime= restTime+5;
                    inputRestTime.setText(Integer.toString(restTime));
                }
            }
        });

        minusButtonForWorkOutTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputWorkOutTime.getText().toString().equals("")||(!inputWorkOutTime.getText().toString().equals("")&&Integer.valueOf(inputWorkOutTime.getText().toString())<2)){
                    Toast.makeText(MainActivity.this, "Invalid Time!", Toast.LENGTH_LONG).show();

                }
                else{
                    int workOutTime = Integer.valueOf(inputWorkOutTime.getText().toString());
                    workOutTime = workOutTime-5;
                    inputWorkOutTime.setText(Integer.toString(workOutTime));
                }
            }
        });

        minusButtonForRestTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputRestTime.getText().toString().equals("")||(!inputRestTime.getText().toString().equals("")&&Integer.valueOf(inputRestTime.getText().toString())<2)){
                    Toast.makeText(MainActivity.this, "Invalid Time!", Toast.LENGTH_LONG).show();

                }
                else {
                    int restTime = Integer.valueOf(inputRestTime.getText().toString());
                    restTime= restTime-5;
                    inputRestTime.setText(Integer.toString(restTime));
                }
            }
        });

        Button startWorkout = (Button)findViewById(R.id.button2);
        startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Workout.class);

                intent.putExtra("Work", inputWorkOutTime.getText().toString());
                intent.putExtra("Rest", inputRestTime.getText().toString());
                startActivity(intent);

            }
        });


    }
}
