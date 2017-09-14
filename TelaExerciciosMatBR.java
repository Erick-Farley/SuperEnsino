package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaExerciciosMatBR extends AppCompatActivity {
    Button vMais1;
    Button video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_exercicios_mat_br);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        vMais1 = (Button) findViewById(R.id.vMais1matBr);
        video = (Button) findViewById(R.id.video);


        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volta = new Intent(TelaExerciciosMatBR.this, TelaVideosPortBR.class);
                startActivity(volta);
            }
        });


        vMais1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abre = new Intent(TelaExerciciosMatBR.this, TelaQuizMatBr.class);
                startActivity(abre);
            }
        });


    }
    protected void onPause() {
        super.onPause();
    }

}
