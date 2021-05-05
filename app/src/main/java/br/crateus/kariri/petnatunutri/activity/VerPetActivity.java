package br.crateus.kariri.petnatunutri.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.crateus.kariri.petnatunutri.R;
import br.crateus.kariri.petnatunutri.model.Pet;

public class VerPetActivity extends AppCompatActivity {

    TextView nome, peso, nascimento, especie, raca, sexo;
    FirebaseDatabase mDatabase;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pet);

        nome = (TextView) findViewById(R.id.tvNomeDP);
        peso = (TextView) findViewById(R.id.tvPesoDP);
        sexo = (TextView) findViewById(R.id.tvSexoDP);
        especie = (TextView) findViewById(R.id.tvEspecieDP);
        raca = (TextView) findViewById(R.id.tvRacaDP);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance("https://pet-natu-default-rtdb.firebaseio.com/");
        DatabaseReference myref = mDatabase.getReference();

        nome.setText(getIntent().getExtras().getString("nomePet"));
//        nomeTutor.setText(getIntent().getExtras().getString("cpfTutor"));
        peso.setText(getIntent().getExtras().getString("peso"));
//        nascimento.setText(getIntent().getExtras().getString("nascimento"));
        especie.setText(getIntent().getExtras().getString("especie"));
        raca.setText(getIntent().getExtras().getString("raca"));
        sexo.setText(getIntent().getExtras().getString("sexo"));

    }
}