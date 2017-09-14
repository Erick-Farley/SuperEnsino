package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaVideosMat extends AppCompatActivity {

    Button play1, play2, play3,voltar;


    Button exercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_videos_mat);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        exercicios = (Button) findViewById(R.id.listas);

        play1 = (Button)findViewById(R.id.play1);
        play2 = (Button)findViewById(R.id.play2);
        play3 = (Button)findViewById(R.id.play3);
        voltar = (Button)findViewById(R.id.voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(TelaVideosMat.this,TelaMateriaRef.class);
                startActivity(voltar);
            }
        });


        exercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreQuiz = new Intent(TelaVideosMat.this, TelaExerciciosMat.class);
                startActivity(abreQuiz);
            }
        });

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video1 = new Intent(TelaVideosMat.this, TelaVideoOrdem.class);
                startActivity(video1);
            }
        });

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video2 = new Intent(TelaVideosMat.this, TelaVideoClasse.class);
                startActivity(video2);
            }
        });

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video3 = new Intent(TelaVideosMat.this, TelaVideoDeccomposicao.class);
                startActivity(video3);
            }
        });



    }

}
