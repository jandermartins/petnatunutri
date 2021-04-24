package br.crateus.kariri.petnatunutri.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.crateus.kariri.petnatunutri.R;
import br.crateus.kariri.petnatunutri.model.Nutricionista;

public class MeusDadosActivity extends AppCompatActivity {

    EditText nome, cpf, crmv, especialidade;
    Button btSalvar;

    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_dados);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://petnatunutri-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference();


        nome = (EditText) findViewById(R.id.etNomeDados);
        cpf = (EditText) findViewById(R.id.etCpfMD);
        crmv = (EditText) findViewById(R.id.etCrmvMD);
        especialidade = (EditText) findViewById(R.id.etEspecialidadeMD);
        btSalvar = (Button) findViewById(R.id.btSalvarMD);

        myRef.child("usuario").child(mUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                nome.setText(snapshot.getValue(Nutricionista.class).getNome());
                cpf.setText(snapshot.getValue(Nutricionista.class).getCpf());
                crmv.setText(snapshot.getValue(Nutricionista.class).getCrn());
                especialidade.setText(snapshot.getValue(Nutricionista.class).getEspecialidade());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nutricionista nutricionista = new Nutricionista(mUser.getUid(), nome.getText().toString(),
                        cpf.getText().toString(), crmv.getText().toString(), especialidade.getText().toString());
                myRef.child("usuario").child(mUser.getUid()).setValue(nutricionista);
            }
        });



    }
}