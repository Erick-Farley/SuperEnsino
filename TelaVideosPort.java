package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaVideosPort extends AppCompatActivity {

    Button play1, play2, play3,voltar;


    Button exercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_videos_port);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        exercicios = (Button) findViewById(R.id.listas);

        play1 = (Button)findViewById(R.id.play1);
        play2 = (Button)findViewById(R.id.play2);
        play3 = (Button)findViewById(R.id.play3);


        voltar = (Button)findViewById(R.id.voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(TelaVideosPort.this,TelaMateriaBR.class);
                startActivity(voltar);
            }
        });


        exercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vai = new Intent(TelaVideosPort.this, TelaExercicosPort.class);
                startActivity(vai);
            }
        });

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrevideo1 = new Intent(TelaVideosPort.this, TelaVideoLetras.class);
                startActivity(abrevideo1);
            }
        });

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrevideo2 = new Intent(TelaVideosPort.this, TelaVideoDigrafos.class);
                startActivity(abrevideo2);
            }
        });

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrevideo3 = new Intent(TelaVideosPort.this, TelaVideoEmprego.class);
                startActivity(abrevideo3);
            }
        });



    }
}
