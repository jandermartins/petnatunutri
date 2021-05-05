package br.crateus.kariri.petnatunutri.activity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.crateus.kariri.petnatunutri.R;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView nomePet;
    public ImageButton btMore;

    public LineHolder(@NonNull View itemView) {
        super(itemView);
        nomePet = (TextView) itemView.findViewById(R.id.tvNomePetRv);
        btMore = (ImageButton) itemView.findViewById(R.id.btMaisPet);
    }
}
