package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaMateriaRef extends AppCompatActivity {
    Button btnMat,btnPort;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_materia_ref);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btnMat = (Button)findViewById(R.id.btnMat);
        voltar  = (Button)findViewById(R.id.voltar);
        btnPort = (Button)findViewById(R.id.btnPort);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(TelaMateriaRef.this, TelaBimestre.class);
                startActivity(voltar);
            }
        });

        btnMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prox = new Intent(TelaMateriaRef.this, TelaVideosMat.class);
                startActivity(prox);
            }
        });

        btnPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prox2 = new Intent(TelaMateriaRef.this, TelaVideosPort.class);
                startActivity(prox2);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
}
