package main.entity;

import java.util.Date;
import java.util.UUID;

public class Patrimonio {

   private String numeroTombo;
   private String descricao;
   private String estado;
   private String dataAquisicao;
   private Instituicao instituicao;
   private String idInstituicao;
   private Sala sala;


   public Patrimonio(Patrimonio patrimonio){
       this.numeroTombo = patrimonio.getNumeroTombo();
       this.descricao = patrimonio.getDescricao();
       this.estado = patrimonio.getEstado();
       this.dataAquisicao = patrimonio.getDataAquisicao();
       this.idInstituicao = patrimonio.getIdInstituicao();
       this.sala = new Sala(patrimonio.getSala().getNumeroDaSala(), patrimonio.getSala().getUnidade(), idInstituicao);
   }

    public Patrimonio(String tombo, String descricao, String estado, String dataAquisicao, String idInstituicao, String numSala, String unidadeSala) {
        this.numeroTombo = tombo;
        this.descricao = descricao;
        this.estado = estado;
        this.dataAquisicao = dataAquisicao;
        this.idInstituicao = idInstituicao;
        this.sala = new Sala(numSala, unidadeSala, idInstituicao);
    }

    public String getNumeroTombo() {
        return numeroTombo;
    }

    public void setNumeroTombo(String numeroTombo) {
        this.numeroTombo = numeroTombo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setIdInstituicao(String idInstituicao){this.idInstituicao = idInstituicao;}

    public String getIdInstituicao(){
        return idInstituicao;
    }

    public String getPatrimonioCompleto(Patrimonio patrimonio){
        return patrimonio.getNumeroTombo() + "," + patrimonio.getDescricao() + "," + patrimonio.getEstado() + "," + patrimonio.getDataAquisicao() + "," + patrimonio.getIdInstituicao() + "," + sala.getNumeroDaSala() + "," + sala.getUnidade();
    }
}
