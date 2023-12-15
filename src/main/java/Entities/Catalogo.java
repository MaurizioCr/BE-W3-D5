package Entities;


import javax.persistence.*;

@Entity
@Table(name = "animals")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class  Catalogo {
    @Id
    @GeneratedValue
    protected long ISBN;
    String Title;
    String annoDiPubblicazione;
    int numeroPagine;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(String annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public Catalogo(String title, String annoDiPubblicazione, int numeroPagine) {
        Title = title;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }
    public Catalogo(){

    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + ISBN +
                ", Title='" + Title + '\'' +
                ", annoDiPubblicazione='" + annoDiPubblicazione + '\'' +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
