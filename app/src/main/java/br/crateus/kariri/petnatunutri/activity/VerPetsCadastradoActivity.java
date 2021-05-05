package br.crateus.kariri.petnatunutri.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.crateus.kariri.petnatunutri.R;
import br.crateus.kariri.petnatunutri.model.Pet;

public class VerPetsCadastradoActivity extends AppCompatActivity {

    LineAdapter lineAdapter;
    FirebaseDatabase mDatabase;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pets_cadastrado);

        RecyclerView rvPets = (RecyclerView) findViewById(R.id.rvVerPetsCadastrado);
        LinearLayoutManager layoutManager = new LinearLayoutManager(VerPetsCadastradoActivity.this);

        rvPets.setLayoutManager(layoutManager);
        lineAdapter = new LineAdapter(new ArrayList(0));
        rvPets.setAdapter(lineAdapter);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance("https://pet-natu-default-rtdb.firebaseio.com/");
        DatabaseReference myref = mDatabase.getReference();

        Pet pet = new Pet();
        pet.setNome("kuduro");
        pet.setIdPet("123");
        lineAdapter.inserirItem(pet);


//        myref.child("pets").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot pets : snapshot.getChildren()) {
//                    Log.i("dados", snapshot.getChildren().toString());
//                    Pet pet = new Pet();
//
////                    pet.setIdPet(pets.getValue(Pet.class).getIdPet());
////                    pet.setNome(pets.getValue(Pet.class).getNome());
//                    pet.setCpfTutor(pets.getValue(Pet.class).getCpfTutor());
//                    pet.setEspecie(pets.getValue(Pet.class).getEspecie());
//                    pet.setRaca(pets.getValue(Pet.class).getRaca());
//                    pet.setPeso(pets.getValue(Pet.class).getPeso());
//                    pet.setNascimento(pets.getValue(Pet.class).getNascimento());
//                    pet.setSexo(pets.getValue(Pet.class).getSexo());
//                    lineAdapter.inserirItem(pet);
//                }
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(VerPetsCadastradoActivity.this, "Não foi possivel carregar a lista de Pets", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}