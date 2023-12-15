package mauriziocrispino.Entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Libri extends Catalogo{
    String autore;
    String genere;

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Libri(String title, Date annoDiPubblicazione, int numeroPagine, String autore, String genere) {
        super(title, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libri() {
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", ISBN=" + ISBN +
                ", Title='" + Title + '\'' +
                ", annoDiPubblicazione='" + annoDiPubblicazione + '\'' +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
