package Applicazione;

import mauriziocrispino.DAO.CatalogoDAO;
import mauriziocrispino.DAO.UtenteDAO;
import mauriziocrispino.Entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.xml.bind.DatatypeConverter.parseDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Libreria");

        public static void main(String[] args) {

            EntityManager em = emf.createEntityManager();
            CatalogoDAO sd = new CatalogoDAO(em);
            UtenteDAO ud = new UtenteDAO(em);

            Date dataNascita = parseDate("2004-07-02");
            //Utente utente = new Utente("Maurizio", "Crispino", dataNascita, 13345);
            //ud.findByIdAndDelete(utente.getNumeroDiTessera());
            //ud.save(utente);

            Date annoDiPubblicazione = parseDate("1955/06/02");
            Libri libro = new Libri("Il signore degli anelli", annoDiPubblicazione, 1000, "J.R.R. Tolkien", "Fantasy");
            //sd.findByIdAndDelete(1);
            //sd.save(libro);

            //Date annoDiPubblicazione2 = parseDate("2023/04/20");
            //Riviste rivista = new Riviste("National Geographic", annoDiPubblicazione2, 50, Periodicità.MENSILE);
                System.out.println(sd.findLibriById(11));
            //sd.findByIdAndDelete(2);
            //sd.save(rivista);

            //Prestito prestitoLibro = new Prestito(utente, libro, new Date());

            //Prestito prestitoRivista = new Prestito(utente, rivista, new Date());




            /*System.out.println("Informazioni utente: " + utente);
            System.out.println("Informazioni libro: " + libro);
            System.out.println("Informazioni rivista: " + rivista);
            System.out.println("Informazioni prestito (libro): " + prestitoLibro);
            System.out.println("Informazioni prestito (rivista): " + prestitoRivista);*/

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

