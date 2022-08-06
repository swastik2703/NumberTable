package com.example.numbertable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timeTableListView;

    public void generateTable(int tableNumber){
        ArrayList<String> table = new ArrayList<String>();
        //display table till 20
        for(int j = 1; j<= 10; j++){
            table.add((tableNumber+ " * "+ j+ " = "+ j*tableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,table);
        timeTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableSeekBar = findViewById(R.id.timeTableSeekBar);
        timeTableListView = findViewById(R.id.timeTableListView);
        int max = 20;
        int Start = 10;

        //set max value of seekbar
        timeTableSeekBar.setMax(max);
        //set progress of seekbar
        timeTableSeekBar.setProgress(Start);
        generateTable(Start);

        //now work with on click listener
        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //here we right how seek bar is progressing
                int min = 1;
                int tableNumber;

                if(progress < min){
                    tableNumber = min;
                    timeTableSeekBar.setProgress(min);
                }
                else{
                    tableNumber = progress;
                }

                Log.i("SeekBar Working", Integer.toString(tableNumber));
                generateTable(tableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}