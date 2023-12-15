package mauriziocrispino.Entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Riviste extends Catalogo{
public Periodicità periodicità;

    public Riviste(String title, Date annoDiPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(title, annoDiPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }
    public  Riviste(){

    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                ", ISBN=" + ISBN +
                ", Title='" + titolo + '\'' +
                ", annoDiPubblicazione='" + annoDiPubblicazione + '\'' +
                "periodicità=" + periodicità +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
