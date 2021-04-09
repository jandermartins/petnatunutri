package br.crateus.kariri.petnatunutri.model;

public class Dieta {

    private String nomePrato, descricao, calorias;

    public Dieta(){

    }

    public Dieta(String nomePrato, String descricao, String calorias) {
        this.nomePrato = nomePrato;
        this.descricao = descricao;
        this.calorias = calorias;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }
}
