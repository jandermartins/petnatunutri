package br.crateus.kariri.petnatunutri.model;

public class Nutricionista {

    private String id, nome, cpf, crn, especialidade;

    public Nutricionista(String id, String nome, String cpf, String crn, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.crn = crn;
        this.especialidade = especialidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Nutricionista(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
