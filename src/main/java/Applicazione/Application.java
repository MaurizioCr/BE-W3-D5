package Applicazione;

import mauriziocrispino.Entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static javax.xml.bind.DatatypeConverter.parseDate;

public class Application {

        public static void main(String[] args) {

            Date dataNascita = parseDate("2004-07-02");
            Utente utente = new Utente("Maurizio", "Crispino", dataNascita, 12345);


            Date annoDiPubblicazione = parseDate("1955/06/02");
            Libri libro = new Libri("Il signore degli anelli", annoDiPubblicazione, 1000, "J.R.R. Tolkien", "Fantasy");


            Date annoDiPubblicazione2 = parseDate("2023/04/20");
            Riviste rivista = new Riviste("National Geographic", annoDiPubblicazione2, 50, Periodicità.MENSILE);

            Prestito prestitoLibro = new Prestito(utente, libro, new Date());

            Prestito prestitoRivista = new Prestito(utente, rivista, new Date());




            System.out.println("Informazioni utente: " + utente);
            System.out.println("Informazioni libro: " + libro);
            System.out.println("Informazioni rivista: " + rivista);
            System.out.println("Informazioni prestito (libro): " + prestitoLibro);
            System.out.println("Informazioni prestito (rivista): " + prestitoRivista);

        }

    private static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

