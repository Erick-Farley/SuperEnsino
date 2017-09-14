package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaSerieRef extends AppCompatActivity {
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button voltar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_serie_ref);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btn5= (Button)findViewById(R.id.btn5);
        btn6= (Button)findViewById(R.id.btn6);
        btn7= (Button)findViewById(R.id.btn7);
        btn8= (Button)findViewById(R.id.btn8);
        btn9= (Button)findViewById(R.id.btn9);

        voltar = (Button)findViewById(R.id.voltar);


        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(TelaSerieRef.this, TelaModulo.class);
                startActivity(voltar);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreMateria1 = new Intent(TelaSerieRef.this, TelaBimestre.class);
                startActivity(abreMateria1);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreMateria2 = new Intent(TelaSerieRef.this, TelaBimestre.class);
                startActivity(abreMateria2);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreMateria3 = new Intent(TelaSerieRef.this, TelaBimestre.class);
                startActivity(abreMateria3);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreMateria4 = new Intent(TelaSerieRef.this, TelaBimestre.class);
                startActivity(abreMateria4);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreMateria5 = new Intent(TelaSerieRef.this, TelaBimestre.class);
                startActivity(abreMateria5);
            }
        });


    }
    protected void onPause() {
        super.onPause();
    }


}
