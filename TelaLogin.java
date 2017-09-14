package com.example.pipeline.superensino3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaLogin extends AppCompatActivity {Button btnLogar;
    EditText editMatricula, editSenha;
    String url="";
    String parametros="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnLogar=(Button)findViewById(R.id.btnLogar);
        editMatricula=(EditText)findViewById(R.id.editMatricula);
        editSenha=(EditText)findViewById(R.id.editSenha);

        /*btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()){
                    String matricula = editMatricula.getText().toString();
                    String senha = editSenha.getText().toString();

                    if (matricula.isEmpty() || senha.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Nenhum campo pode ficar vazio", Toast.LENGTH_LONG).show();
                    }else {
                        url = "http://192.168.1.5/login/logar.php";
                        parametros = "email=" + matricula + "&senha=" + senha;
                        new SolicitaDados().execute(url);
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Sem conexão com internet", Toast.LENGTH_LONG).show();
                }
            }
        });*/
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreModulo = new Intent(TelaLogin.this, TelaModulo.class);
                startActivity(abreModulo);
            }
        });

    }
    /*private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return Conexao.postDados(urls[0], parametros);
        }

        @Override
        protected void onPostExecute(String resultado) {
            if (resultado.contains("login_ok")){
                Intent abreInicio = new Intent(TelaLogin.this, TelaModulo.class);
                startActivity(abreInicio);
            }else {
                Toast.makeText(getApplicationContext(), "Usuario ou senha incorretos", Toast.LENGTH_LONG).show();
            }
        }
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
