package br.crateus.kariri.petnatunutri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PainelAdmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_adm);

        Button btCadastrarPet, btVerCadastro, btCadastraTutor;

        btCadastrarPet = (Button) findViewById(R.id.btAtribuirDieta);
        btVerCadastro = (Button) findViewById(R.id.btVerCadastroPa);
        btCadastraTutor = (Button) findViewById(R.id.btCadastrarNovaDieta);

        btCadastrarPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PainelAdmActivity.this, CadastrarPetActivity.class));
            }
        });

        btCadastraTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PainelAdmActivity.this, CadastrarTutorActivity.class));
            }
        });
    }
}