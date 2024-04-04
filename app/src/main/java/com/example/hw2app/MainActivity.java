package com.example.hw2app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView1,textView2;
    CheckBox checkBox;

    RadioGroup rGroup1;

    RadioButton rdoDog,rdoCat,rdoRabbit;

    Button button;
    ImageView imgPet;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        textView1=(TextView) findViewById(R.id.textView1);
        checkBox=(CheckBox) findViewById(R.id.checkBox);

        textView2=(TextView) findViewById(R.id.textView2);
        rGroup1=(RadioGroup) findViewById(R.id.rGroup1);
        rdoCat=(RadioButton) findViewById(R.id.RdoCat);
        rdoDog=(RadioButton)  findViewById(R.id.RdoDog);
        rdoRabbit=(RadioButton) findViewById(R.id.RdoRabbit);

        button=(Button) findViewById(R.id.button);
        imgPet=(ImageView) findViewById(R.id.ImgPet);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (checkBox.isChecked()==true){
                    textView2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }else{
                    textView2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                int checkedRadio=rGroup1.getCheckedRadioButtonId();
                if(checkedRadio==R.id.RdoDog){
                    imgPet.setImageResource(R.drawable.dog);
                } else if (checkedRadio==R.id.RdoCat)
                {
                    imgPet.setImageResource(R.drawable.cat);
                } else if (checkedRadio==R.id.RdoRabbit) {
                    imgPet.setImageResource(R.drawable.rabbit);
                }else {
                    Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}