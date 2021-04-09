package br.crateus.kariri.petnatunutri.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.crateus.kariri.petnatunutri.R;
import br.crateus.kariri.petnatunutri.model.Dieta;

public class CadastrarNovaDietaActivity extends AppCompatActivity {

    EditText etNome, etDescricao, etCalorias;
    Button btCadastrar;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_nova_dieta);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://petnatunutri-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference();

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        etNome = (EditText) findViewById(R.id.etNomeDoPrato);
        etDescricao = (EditText) findViewById(R.id.etDescricaoDoPrato);
        etCalorias = (EditText) findViewById(R.id.etCalorias);

        btCadastrar = (Button) findViewById(R.id.btCadastraPrato);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dieta dieta = new Dieta(etNome.getText().toString(), etDescricao.getText().toString(), etCalorias.getText().toString());
                String hashCode = String.valueOf(dieta.hashCode());
                myRef.child("dietas").child(mUser.getUid()).child(hashCode).setValue(dieta);

                Toast.makeText(CadastrarNovaDietaActivity.this, "Dieta Cadastrada Com Sucesso", Toast.LENGTH_SHORT).show();
                etNome.setText("");
                etDescricao.setText("");
                etCalorias.setText("");
            }
        });
    }
}