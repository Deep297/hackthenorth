package project.hackthenorth.com.hackthenorth;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutFragment extends Fragment {
    EditText inputWorkOutTime, inputRestTime, inputCycleTime;
    Button plusButtonForWorkOutTime, plusButtonForRestTime, minusButtonForWorkOutTime, minusButtonForRestTime,plusCycle, minusCycle;

    public static WorkoutFragment newInstance() {
        WorkoutFragment fragment = new WorkoutFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Event listeners
        Activity activity = getActivity();

        inputWorkOutTime = (EditText)getView().findViewById(R.id.inputWorkOutTime);
        inputRestTime = (EditText)getView().findViewById(R.id.inputRestTime);
        inputCycleTime = (EditText)getView().findViewById(R.id.inputCycleTime);

        plusButtonForRestTime = (Button)getView().findViewById(R.id.plusButtonForRest);
        plusButtonForWorkOutTime = (Button)getView().findViewById(R.id.plusButtonForWorkOut);
        minusButtonForRestTime = (Button)getView().findViewById(R.id.minusButtonForRest);
        minusButtonForWorkOutTime = (Button)getView().findViewById(R.id.minusButtonForWorkOut);
        plusCycle = (Button) getView().findViewById(R.id.plusButtonForCycle);
        minusCycle = (Button) getView().findViewById(R.id.minusCycleTime);

        if (inputWorkOutTime.getText().toString().equals("0")||inputRestTime.getText().toString().equals("0")){
            Toast.makeText(activity, "Invalid Time!", Toast.LENGTH_LONG).show();

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
                    Toast.makeText(getActivity(), "Invalid Time!", Toast.LENGTH_LONG).show();

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
                    Toast.makeText(getActivity(), "Invalid Time!", Toast.LENGTH_LONG).show();

                }
                else {
                    int restTime = Integer.valueOf(inputRestTime.getText().toString());
                    restTime= restTime-5;
                    inputRestTime.setText(Integer.toString(restTime));
                }
            }
        });

        Button startWorkout = (Button)activity.findViewById(R.id.button2);
        startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Workout.class);

                intent.putExtra("Work", inputWorkOutTime.getText().toString());
                intent.putExtra("Rest", inputRestTime.getText().toString());
                startActivity(intent);
            }
        });

        plusCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputCycleTime.getText().toString().equals("")){
                    inputCycleTime.setText("0");
                    int cycleTime = Integer.valueOf(inputCycleTime.getText().toString());
                    cycleTime = cycleTime+1;
                    inputCycleTime.setText(Integer.toString(cycleTime));
                }
                else {
                    int cycleTime = Integer.valueOf(inputCycleTime.getText().toString());
                    cycleTime = cycleTime+1;
                    inputCycleTime.setText(Integer.toString(cycleTime));
                }
            }
        });

        minusCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputCycleTime.getText().toString().equals("") || Integer.valueOf(inputCycleTime.getText().toString()) <= 0){
                    Toast.makeText(getActivity(), "Invalid Cycle Number!", Toast.LENGTH_LONG).show();
                }
                else {
                    int cycleTime = Integer.valueOf(inputCycleTime.getText().toString());
                    cycleTime = cycleTime-1;
                    inputCycleTime.setText(Integer.toString(cycleTime));
                }
            }
        });

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_workout, container, false);

        return inflater.inflate(R.layout.fragment_workout, container, false);
    }
}
