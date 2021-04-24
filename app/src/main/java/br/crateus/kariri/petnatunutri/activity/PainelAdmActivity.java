package br.crateus.kariri.petnatunutri.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.crateus.kariri.petnatunutri.R;

public class PainelAdmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_adm);

        Button btCadastrarNovaDieta, btAtribuiNovaDieta, btBuscarTutor;

        btCadastrarNovaDieta = (Button) findViewById(R.id.btCadastrarNovaDieta);
        btAtribuiNovaDieta = (Button) findViewById(R.id.btAtribuirDieta);
        btBuscarTutor = (Button) findViewById(R.id.btBuscarTuto);

        btCadastrarNovaDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PainelAdmActivity.this, CadastrarNovaDietaActivity.class));
            }
        });

        btAtribuiNovaDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(PainelAdmActivity.this, AtribuirDietaActivity.class));
            }
        });
    }
}