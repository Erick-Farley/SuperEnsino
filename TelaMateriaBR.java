package com.example.pipeline.superensino3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaMateriaBR extends AppCompatActivity {

    Button btnMat, btnPort,voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_materia_br);

        btnMat = (Button)findViewById(R.id.btnMatBr);
        btnPort = (Button)findViewById(R.id.btnPortBr1);
        voltar = (Button)findViewById(R.id.voltar);

        btnMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video = new Intent(TelaMateriaBR.this, TelaVideosMatBR.class);
                startActivity(video);
            }
        });

        btnPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abre = new Intent(TelaMateriaBR.this, TelaVideosPortBR.class);
                startActivity(abre);
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(TelaMateriaBR.this, TelaSerieBR.class);
                startActivity(voltar);
            }
        });

    }
}
