package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaVideosPortBR extends AppCompatActivity {

    Button play1, play2, play3, play4,voltar;


    Button exercicios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_videos_port_br);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        exercicios = (Button) findViewById(R.id.listas);

        play1 = (Button)findViewById(R.id.play1);
        play2 = (Button)findViewById(R.id.play2);
        play3 = (Button)findViewById(R.id.play3);
        play4 = (Button)findViewById(R.id.play4);

        voltar = (Button)findViewById(R.id.voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(TelaVideosPortBR.this,TelaMateriaBR.class);
                startActivity(voltar);
            }
        });


        exercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreQuiz = new Intent(TelaVideosPortBR.this, TelaExerciciosMat.class);
                startActivity(abreQuiz);
            }
        });

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrevideo1 = new Intent(TelaVideosPortBR.this, TelaVideoPortAula1.class);
                startActivity(abrevideo1);
            }
        });

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrevideo2 = new Intent(TelaVideosPortBR.this, TelaVideoPortAula2.class);
                startActivity(abrevideo2);
            }
        });

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrevideo3 = new Intent(TelaVideosPortBR.this, TelaVidePortAula3.class);
                startActivity(abrevideo3);
            }
        });

        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrevideo4 = new Intent(TelaVideosPortBR.this, TelaVideoPortAula4.class);
                startActivity(abrevideo4);
            }
        });
    }

}
