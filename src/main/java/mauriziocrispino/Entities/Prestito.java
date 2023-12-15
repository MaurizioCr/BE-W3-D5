package mauriziocrispino.Entities;
import java.util.Date;

public class Prestito {
    private Utente utente;
    private Catalogo elementoPrestato;
    private Date dataInizioPrestito;
    private Date dataRestituzionePrevista;
    private Date dataRestituzioneEffettiva;

    public Prestito(Utente utente, Catalogo elementoPrestato, Date dataInizioPrestito) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = calcolaDataRestituzionePrevista(dataInizioPrestito);
    }

    private Date calcolaDataRestituzionePrevista(Date dataInizio) {
        long giorniInMillisecondi = 30L * 24 * 60 * 60 * 1000;
        return new Date(dataInizio.getTime() + giorniInMillisecondi);
    }


    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}

