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
    EditText inputWorkOutTime, inputRestTime, inputCycleTime;
    Button plusButtonForWorkOutTime, plusButtonForRestTime, minusButtonForWorkOutTime, minusButtonForRestTime, plusCycle, minusCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputWorkOutTime = (EditText)findViewById(R.id.inputWorkOutTime);
        inputRestTime = (EditText)findViewById(R.id.inputRestTime);
        inputCycleTime = (EditText)findViewById(R.id.inputCycleTime);

        plusButtonForRestTime = (Button)findViewById(R.id.plusButtonForRest);
        plusButtonForWorkOutTime = (Button)findViewById(R.id.plusButtonForWorkOut);
        minusButtonForRestTime = (Button)findViewById(R.id.minusButtonForRest);
        minusButtonForWorkOutTime = (Button)findViewById(R.id.minusButtonForWorkOut);
        plusCycle = (Button) findViewById(R.id.plusButtonForCycle);
        minusCycle = (Button) findViewById(R.id.minusCycleTime);

        if (inputWorkOutTime.getText().toString().equals("0")||inputRestTime.getText().toString().equals("0")||inputCycleTime.getText().toString().equals("0")){
            Toast.makeText(MainActivity.this, "Invalid Time or Cycle!", Toast.LENGTH_LONG).show();

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

        plusCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputCycleTime.getText().toString().equals("")){
                    inputCycleTime.setText("0");
                    int cycles = Integer.valueOf(inputCycleTime.getText().toString());
                    cycles = cycles +1;
                    inputCycleTime.setText(Integer.toString(cycles));

                }
                else {
                    int cycleTime = Integer.valueOf(inputCycleTime.getText().toString());
                    cycleTime= cycleTime+1;
                    inputCycleTime.setText(Integer.toString(cycleTime));
                }
            }

        });

        minusCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputCycleTime.getText().toString().equals("")||(!inputCycleTime.getText().toString().equals("")&&Integer.valueOf(inputCycleTime.getText().toString())<2)){
                    Toast.makeText(MainActivity.this, "Invalid Cycle Number!", Toast.LENGTH_LONG).show();

                }
                else {
                    int cycleTime = Integer.valueOf(inputCycleTime.getText().toString());
                    cycleTime= cycleTime-1;
                    inputCycleTime.setText(Integer.toString(cycleTime));
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
                intent.putExtra("Cycles", inputCycleTime.getText().toString());
                startActivity(intent);

            }
        });


    }
}
