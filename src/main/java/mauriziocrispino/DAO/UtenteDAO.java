package mauriziocrispino.DAO;

import mauriziocrispino.Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {

    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(utente);
        transaction.commit();

        System.out.println("Persona " + utente.getNumeroDiTessera() +" "+ utente.getNome() +" "+utente.getCognome() + " aggiunto correttamente!");
    }

    public Utente findById(int numeroDiTessera) {
        return em.find(Utente.class, numeroDiTessera);
    }


    public void findByIdAndDelete(int numeroDiTessera) {
        Utente found = this.findById(numeroDiTessera);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.remove(found);
            transaction.commit();

            System.out.println("La persona " + found.getNumeroDiTessera() +" "+ found.getNome() +" "+ found.getCognome() +" eliminato correttamente!");
        } else {
            System.out.println("La persona " + numeroDiTessera + " non è stato trovato");
        }


    }
}