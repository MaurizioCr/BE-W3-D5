package mauriziocrispino.DAO;

import mauriziocrispino.Entities.Catalogo;
import mauriziocrispino.Entities.Libri;
import mauriziocrispino.Entities.Riviste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CatalogoDAO {


    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public Catalogo findById(long id) {
        return em.find(Catalogo.class, id);
    }

    public Libri findCatById(long id) {
        return em.find(Libri.class, id);
    }

    public Riviste findDogById(long id) {
        return em.find(Riviste.class, id);
    }

    public void save(Catalogo a) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(a);
        transaction.commit();
        System.out.println("Nuovo Catalogo salvato correttamente");
    }

    public void findByIdAndDelete(long id) {
        Catalogo found = em.find(Catalogo.class, id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'Animal è stato cancellato correttamente");
        } else {
            System.err.println("L'Animal con l'id " + id + " non è stato trovato");
        }
    }}

