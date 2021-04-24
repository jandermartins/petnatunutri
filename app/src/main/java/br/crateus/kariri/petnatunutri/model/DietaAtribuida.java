package br.crateus.kariri.petnatunutri.model;

public class DietaAtribuida {
    private String idPet, cpfTutor, idPrato;

    public DietaAtribuida(){

    }

    public DietaAtribuida(String idPet, String cpfTutor, String idPrato) {
        this.idPet = idPet;
        this.cpfTutor = cpfTutor;
        this.idPrato = idPrato;
    }

    public String getIdPet() {
        return idPet;
    }

    public void setIdPet(String idPet) {
        this.idPet = idPet;
    }

    public String getCpfTutor() {
        return cpfTutor;
    }

    public void setCpfTutor(String cpfTutor) {
        this.cpfTutor = cpfTutor;
    }

    public String getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(String idPrato) {
        this.idPrato = idPrato;
    }
}
