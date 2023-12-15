package mauriziocrispino.Entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Catalogo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class  Catalogo {
    @Id
    @GeneratedValue
    protected long ISBN;
    String titolo;
    Date annoDiPubblicazione;
    int numeroPagine;

    public String getTitle() {
        return titolo;
    }

    public void setTitle(String title) {
        this.titolo = title;
    }

    public Date getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(Date annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public Catalogo(String titolo, Date annoDiPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }
    public Catalogo(){

    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione='" + annoDiPubblicazione + '\'' +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
