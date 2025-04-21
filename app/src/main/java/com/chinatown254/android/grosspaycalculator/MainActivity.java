package com.chinatown254.android.grosspaycalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
 public  TextView error ,grossPay;
 public  Button calculate ;
 public  EditText hours , rate ;
Double hourlyRate , hoursWorked , gross;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rate =  findViewById(R.id.edPayRate);
        hours = findViewById(R.id.edHours);
        calculate = findViewById(R.id.caluclate);
        grossPay = findViewById(R.id.TVPay);
        error = findViewById(R.id.TVTitle);




       // rates = new PayRate(Double.parseDouble(rate.getText().toString()), Double.parseDouble(hours.getText().toString()));

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rate.getText().toString().isEmpty() && !hours.getText().toString().isEmpty()){
                    checkInput();
                }else{
                    Toast.makeText(getApplicationContext(),"Hours or Rate Cannot be left Empty",Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    private void checkInput() {

            hourlyRate = Double.parseDouble(rate.getText().toString());
            hoursWorked = Double.parseDouble(hours.getText().toString());
            CalculateRate();
    }

    private void CalculateRate() {
        PayRate rate = new PayRate(hourlyRate , hoursWorked);
         gross = rate.calculateGrossPay();
         grossPay.setText(gross.toString());

    }

}