package Entities;

import javax.persistence.Entity;

@Entity
public class Riviste extends Catalogo{
public Periodicità periodicità;

    public Riviste(String title, String annoDiPubblicazione, int numeroPagine, Periodicità periodicità) {
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
                ", Title='" + Title + '\'' +
                ", annoDiPubblicazione='" + annoDiPubblicazione + '\'' +
                "periodicità=" + periodicità +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
