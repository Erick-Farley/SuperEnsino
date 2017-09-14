package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaModulo extends AppCompatActivity {

    Button btnBR;
    Button btnRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_modulo);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnRef = (Button)findViewById(R.id.btn_Ref);
        btnBR = (Button)findViewById(R.id.btn_Br);

        btnRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreSerieRef = new Intent(TelaModulo.this, TelaSerieRef.class);
                startActivity(abreSerieRef);
            }
        });
        btnBR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abre = new Intent(TelaModulo.this, TelaMateriaBR.class);
                startActivity(abre);
            }
        });
    }
    protected void onPause() {
        super.onPause();
    }
}