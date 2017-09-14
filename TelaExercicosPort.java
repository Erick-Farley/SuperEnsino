package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaExercicosPort extends AppCompatActivity {

    Button vMais1, vMais2, vMais3;
    Button video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_exercicos_port);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        vMais1 = (Button) findViewById(R.id.vMais1port);
        vMais2 = (Button) findViewById(R.id.vMais2port);
        vMais3 = (Button) findViewById(R.id.vMais3port);

        video = (Button) findViewById(R.id.video);


        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volta = new Intent(TelaExercicosPort.this, TelaVideosPort.class);
                startActivity(volta);
            }
        });


        vMais1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abre = new Intent(TelaExercicosPort.this, TelaQuizLetras.class);
                startActivity(abre);
            }
        });

        vMais2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abre2 = new Intent(TelaExercicosPort.this, TelaQuizPortDigrafo.class);
                startActivity(abre2);
            }
        });

        vMais3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abre3 = new Intent(TelaExercicosPort.this, TelaQuizEmprego.class);
            }
        });

    }
    protected void onPause() {
        super.onPause();
    }


}
