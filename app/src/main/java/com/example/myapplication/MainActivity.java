package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button, button2;
    private Switch aSwitch;
    private CheckBox checkBox;
    private ToggleButton toggleButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        changeTextView();
        setOnBtnClickListener();
        setOnSwCheckedListener();
        setOnTBCheckedListener();
        checkBox();
        setOnClickSecondButton();

    }

    private void initView (){
        textView = findViewById(R.id.myText);
        editText = findViewById(R.id.myEditText);
        button = findViewById(R.id.myButton);
        aSwitch = findViewById(R.id.mySwitch);
        toggleButton = findViewById(R.id.myToggleButton);
        button2 = (Button) findViewById(R.id.myButton2);

    }

    private void checkBox(){
        checkBox = findViewById(R.id.myCheckBox);
        checkBox.setVisibility(View.INVISIBLE);
    }

    private void changeTextView(){
        int color = R.color.teal_200;
        int colorText = ContextCompat.getColor(getApplicationContext(),color);
        textView.setTextColor(colorText);
    }
     private void changeColorButtonOn(){
         int color = R.color.teal_200;
         int colorText = ContextCompat.getColor(getApplicationContext(),color);
         button.setBackgroundColor(colorText);

     }
    private void changeColorButtonOff(){
        int color = R.color.purple_700;
        int colorText = ContextCompat.getColor(getApplicationContext(),color);
        button.setBackgroundColor(colorText);
    }


     private void setOnBtnClickListener(){
        button.setOnClickListener(v -> {
            String string = editText.getText().toString();
           textView.setText(string);
        });
     }

     private void setOnSwCheckedListener(){
        aSwitch.setOnClickListener(v -> {
            if (aSwitch.isChecked()){
                changeColorButtonOn();
            }else {
                changeColorButtonOff();
            }
        });
     }

     private void setOnTBCheckedListener(){
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (toggleButton.isChecked()){
                checkBox.setVisibility(View.VISIBLE);
            }else {
                checkBox.setVisibility(View.INVISIBLE);
            }
        });
     }


    private void setOnClickSecondButton(){
        button2.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);

        });
    }


}