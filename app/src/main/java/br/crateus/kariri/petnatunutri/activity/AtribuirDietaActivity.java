package br.crateus.kariri.petnatunutri.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.crateus.kariri.petnatunutri.R;
import br.crateus.kariri.petnatunutri.model.Dieta;
import br.crateus.kariri.petnatunutri.model.DietaAtribuida;

public class AtribuirDietaActivity extends AppCompatActivity {

    EditText etCpfTutor, etCodPet, etCodDieta;
    Button btAtribuir;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseDatabase mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atribuir_dieta);

        mData = FirebaseDatabase.getInstance("https://petnatunutri-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = mData.getReference();

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        etCpfTutor = (EditText) findViewById(R.id.etCpfTutorAtribuir);
        etCodPet = (EditText) findViewById(R.id.etCodPet);
        etCodDieta = (EditText) findViewById(R.id.etCodDieta);
        btAtribuir = (Button) findViewById(R.id.btAtribuirDietaAD);

        btAtribuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DietaAtribuida dieta = new DietaAtribuida(etCodPet.getText().toString(), etCpfTutor.getText().toString(),
                        etCodDieta.getText().toString());
                myRef.child("petsComDieta").child(etCpfTutor.getText().toString()).
                        child(etCodPet.getText().toString()).child(etCodDieta.getText().toString()).setValue(dieta);
            }
        });
    }
}