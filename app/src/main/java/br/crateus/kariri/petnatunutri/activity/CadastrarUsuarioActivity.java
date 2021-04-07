package br.crateus.kariri.petnatunutri.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.crateus.kariri.petnatunutri.R;
import br.crateus.kariri.petnatunutri.model.Nutricionista;

public class CadastrarUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        FirebaseAuth mAuth;
        FirebaseUser mUser;
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://petnatunutri-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference();

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        EditText etNome = (EditText) findViewById(R.id.etNomeCadastrar);
        EditText etCpf = (EditText) findViewById(R.id.etCpfCadastrar);
        EditText etCrmv = (EditText) findViewById(R.id.etCrnCadastrar);
        EditText etEspecialidade = (EditText) findViewById(R.id.etEspecialidadeCadastrar);
        Button btEnviar = (Button) findViewById(R.id.btCadatroUser);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EscreverNovoUsuario(mUser, etNome, etCpf, etCrmv,etEspecialidade, myRef);
            }
        });
    }
    private void EscreverNovoUsuario(FirebaseUser mUser, EditText etNome, EditText etCpf, EditText etCrmv, EditText etEspecialidade, DatabaseReference myRef) {
        Nutricionista nutricionista = new Nutricionista(mUser.getUid(), etNome.getText().toString(),
                etCpf.getText().toString(), etCrmv.getText().toString(), etEspecialidade.getText().toString());
        Log.i("teste", nutricionista.getNome());
        myRef.child("usuario").child(mUser.getUid()).setValue(nutricionista);
        startActivity(new Intent(CadastrarUsuarioActivity.this, PaginaInicialActivity.class));
    }
}