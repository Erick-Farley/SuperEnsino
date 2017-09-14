package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TelaBimestre extends AppCompatActivity {
    Button btn1bim;
    Button btn2bim;
    Button btn3bim;
    Button btn4bim;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_bimestre);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btn1bim = (Button)findViewById(R.id.btn1bim);
        btn2bim = (Button)findViewById(R.id.btn2bim);
        btn3bim = (Button)findViewById(R.id.btn3bim);
        btn4bim = (Button)findViewById(R.id.btn4bim);
        voltar  = (Button)findViewById(R.id.voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(TelaBimestre.this, TelaSerieRef.class);
                startActivity(voltar);
            }
        });

        btn1bim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreMateria = new Intent(TelaBimestre.this, TelaMateriaRef.class);
                startActivity(abreMateria);

            }
        });
        btn2bim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bimestre fora do periodo", Toast.LENGTH_LONG).show();

            }
        });
        btn3bim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bimestre fora do periodo", Toast.LENGTH_LONG).show();
            }
        });
        btn4bim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Bimestre fora do periodo", Toast.LENGTH_LONG).show();

            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
