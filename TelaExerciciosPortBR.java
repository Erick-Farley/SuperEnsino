package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaExerciciosPortBR extends AppCompatActivity {

    Button vMais1;
    Button video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_exercicios_port_br);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        vMais1 = (Button) findViewById(R.id.vMais1portBr);



        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volta = new Intent(TelaExerciciosPortBR.this, TelaVideosPortBR.class);
                startActivity(volta);
            }
        });


       vMais1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent abre = new Intent(TelaExerciciosPortBR.this, TelaQuizPortBR.class);
               startActivity(abre);
           }
       });


    }
    protected void onPause() {
        super.onPause();
    }


}
