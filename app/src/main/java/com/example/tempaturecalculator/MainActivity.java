package com.example.tempaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_tem;
    RadioButton rb_c;
    RadioButton rb_f;
    Button btn_cal;
    TextView txt_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_tem =  findViewById(R.id.et_tem);
        rb_c = findViewById(R.id.rb_c);
        rb_f = findViewById(R.id.rb_f);
        btn_cal = findViewById(R.id.btn_cal);
        txt_answer = findViewById(R.id.txt_answer);
    }
    @Override
    protected void onResume() {
        super.onResume();
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    private void calculateAnswer() {
            TempCalculate cal = new TempCalculate();
            String value = et_tem.getText().toString();

            if(TextUtils.isEmpty(value)){
                Toast.makeText(this, "Enter the Temperature", Toast.LENGTH_SHORT).show();
            }else {
                float temp = Float.parseFloat(value);
                if(rb_c.isChecked()){
                    temp = cal.convertCelciusToFahrenheit(temp);
                }else if (rb_f.isChecked()){
                    temp = cal.convertFahrenheitToCelcius(temp);

                }else{
                    Toast.makeText(this, "Select the radio button", Toast.LENGTH_SHORT).show();
                    temp = 0.0f;
                }
                txt_answer.setText(new Float(temp).toString());
            }
        }




    }