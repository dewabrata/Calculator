package com.juara.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<String> lstAritmatika;
    Button btnTambah,btn1,btn2,btnSamaDengan;
    EditText txtDisplay;

    int dummyNilai = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTambah = findViewById(R.id.btnPlus);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btnSamaDengan = findViewById(R.id.btnSamaDengan);
        txtDisplay = findViewById(R.id.txtDisplay);


        btnSamaDengan.setOnClickListener(this);
        btnTambah.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        lstAritmatika = new ArrayList<String>();

    }

    public int tambah (int a, int b){
        return a+b;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnSamaDengan){
            txtDisplay.setText( String.valueOf(prosesNilai(lstAritmatika)));
            lstAritmatika.clear();
        }else{

            if (v instanceof Button){



                String nilai = ((Button)v).getText().toString();
                txtDisplay.setText(nilai);

                if(((Button)v).getText().toString().equalsIgnoreCase("=")){
                   txtDisplay.setText( prosesNilai(lstAritmatika));
                }else {
                    lstAritmatika.add(nilai);
                }


            }

        }
    }


    public int prosesNilai(List<String> nilai){

        String operatorBefore ="";
        for(int x= 0; x < nilai.size();x++){


            if (nilai.get(x).equalsIgnoreCase("*") ||nilai.get(x).equalsIgnoreCase("+") || nilai.get(x).equalsIgnoreCase("-") ){
                operatorBefore = nilai.get(x);
            }else{

                if(!operatorBefore.equalsIgnoreCase("")){

                     if (operatorBefore.equalsIgnoreCase("+")){
                         dummyNilai+=Integer.parseInt(nilai.get(x));
                     }
                }else{
                    dummyNilai = Integer.parseInt(nilai.get(x));
                }

            }


        }
        return dummyNilai;
    }
}
