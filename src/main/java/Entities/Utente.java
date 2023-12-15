package Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utente {
    String nome;
    String cognome;
    String dataDiNascita;
    @Id
    int numeroDiTessera;

    public Utente(String nome, String cognome, String dataDiNascita, int numeroDiTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTessera = numeroDiTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(int numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita='" + dataDiNascita + '\'' +
                ", numeroDiTessera=" + numeroDiTessera +
                '}';
    }
}
