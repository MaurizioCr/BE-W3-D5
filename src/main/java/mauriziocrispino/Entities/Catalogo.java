package mauriziocrispino.Entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class  Catalogo {
    @Id
    @GeneratedValue
    protected long ISBN;
    String Title;
    Date annoDiPubblicazione;
    int numeroPagine;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public Catalogo(String title, Date annoDiPubblicazione, int numeroPagine) {
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
