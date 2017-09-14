package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaSerieBR extends AppCompatActivity {

    Button btn5br;
    Button btn9br;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_serie_br);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btn5br= (Button)findViewById(R.id.btn5br);
        btn9br= (Button)findViewById(R.id.btn9br);
        voltar  = (Button)findViewById(R.id.voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(TelaSerieBR.this, TelaModulo.class);
                startActivity(voltar);
            }
        });

        btn5br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreBr = new Intent(TelaSerieBR.this, TelaMateriaBR.class);
                startActivity(abreBr);
            }
        });
        btn9br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreBr = new Intent(TelaSerieBR.this, TelaMateriaBR.class);
                startActivity(abreBr);
            }
        });
    }
    protected void onPause() {
        super.onPause();
    }
}
