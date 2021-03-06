/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.integracampeonatobrasileiro.obj;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author bruno.szczuk
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "classificacaoempate")
public class Classificacao_EM implements Serializable {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.total;
        hash = 17 * hash + Objects.hashCode(this.cdEquipe);
        hash = 17 * hash + this.mandante;
        hash = 17 * hash + this.visitante;
        return hash;
    }

    public Equipe getCdEquipe() {
        return cdEquipe;
    }

    public void setCdEquipe(Equipe cdEquipe) {
        this.cdEquipe = cdEquipe;
    }
    
    @Id
    @Column(name = "cd_equipe")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Classificacao_EM other = (Classificacao_EM) obj;
        if (this.total != other.total) {
            return false;
        }
        if (!Objects.equals(this.cdEquipe, other.cdEquipe)) {
            return false;
        }
        if (this.mandante != other.mandante) {
            return false;
        }
        if (this.visitante != other.visitante) {
            return false;
        }
        return true;
    }

    @JsonProperty("total")
    @Column(name = "qt_total")
    private int total;

    @JsonIgnore
    @JoinColumn(name = "cd_equipe", referencedColumnName = "cd_equipe")
    @OneToOne
    private Equipe cdEquipe;

    @JsonProperty("mandante")
    @Column(name = "qt_mandante")
    private int mandante;

    @JsonProperty("visitante")
    @Column(name = "qt_visitante")
    private int visitante;

    public int getTotal() {
        return total;
    }

    public Classificacao_EM() {
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMandante() {
        return mandante;
    }

    public void setMandante(int mandante) {
        this.mandante = mandante;
    }

    public int getVisitante() {
        return visitante;
    }

    public void setVisitante(int visitante) {
        this.visitante = visitante;
    }

    @Override
    public String toString() {
        return "Classificacao_EM{" + "total=" + total + ", cdEquipe=" + cdEquipe + ", mandante=" + mandante + ", visitante=" + visitante + '}';
    }

}
