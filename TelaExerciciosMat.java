package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaExerciciosMat extends AppCompatActivity {
    Button vi1,v2,v3;
    Button video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_exercicios_mat);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        vi1 = (Button) findViewById(R.id.vMais1mat);
        v2 = (Button) findViewById(R.id.vMais2mat);
        v3 = (Button) findViewById(R.id.vMais3mat);
        video = (Button) findViewById(R.id.video);


        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volta = new Intent(TelaExerciciosMat.this, TelaVideosMat.class);
                startActivity(volta);
            }
        });


        vi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vai = new Intent(TelaExerciciosMat.this, TelaQuiz2Mat.class);
                startActivity(vai);
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz2 = new Intent(TelaExerciciosMat.this, TelaQuizMatClasse.class);
                startActivity(quiz2);
            }
        });

        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abre3 = new Intent(TelaExerciciosMat.this, TelaQuizMatDecomposicao.class);
                startActivity(abre3);
            }
        });

    }
    protected void onPause() {
        super.onPause();
    }


}