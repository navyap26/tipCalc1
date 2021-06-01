package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText bill;
    private EditText tip;
    private TextView totalBill;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        bill = (EditText) findViewById(R.id.billFillBox);
        tip = (EditText) findViewById(R.id.tipFillBox);
        calculate = (Button) findViewById(R.id.calculateButton);
        totalBill = (TextView) findViewById(R.id.totalText);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double billVal = Double.parseDouble(bill.getText().toString());
                double tipVal = Double.parseDouble(tip.getText().toString());
                tipVal = tipVal/100.0;
                double addedAmount = tipVal * billVal;
                double calculation = billVal + addedAmount;
                double totalPayment = Math.round(calculation * 100.0)/100.0;
                String payment = String.valueOf(totalPayment);
                totalBill.setText("Total " + String.valueOf(payment));
            }
        });




    }
}