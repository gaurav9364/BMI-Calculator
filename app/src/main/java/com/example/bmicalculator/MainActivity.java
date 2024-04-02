package com.example.bmicalculator;

import static com.example.bmicalculator.R.id.llMain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity<ConstraintL> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightF, edtHeightI;
        Button button;
        TextView txtResult;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightF = findViewById(R.id.edtHeightF);
        edtHeightI = findViewById(R.id.edtHeightInches);
        button = findViewById(R.id.button);
        txtResult = findViewById(R.id.txtResult);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightF.getText().toString());
                int inches = Integer.parseInt(edtHeightI.getText().toString());

                int totalInches = ft*12 + inches;
                double totalCm = totalInches*2.53;
                double totalM = totalCm/100;

                double bmi = wt/(totalM * totalM);

                if(bmi>25){
                    txtResult.setText("You are OverWeight");
                } else if (bmi<25) {
                    txtResult.setText("You are Underweight");
                }else{
                    txtResult.setText("You are Healthy");
                }
            }
        });
    }
}