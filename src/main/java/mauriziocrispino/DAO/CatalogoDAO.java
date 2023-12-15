package mauriziocrispino.DAO;

import mauriziocrispino.Entities.Catalogo;
import mauriziocrispino.Entities.Libri;
import mauriziocrispino.Entities.Riviste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CatalogoDAO {


    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public Catalogo findById(long id) {
        return em.find(Catalogo.class, id);
    }

    public Libri findLibriById(long id) {
        return em.find(Libri.class, id);
    }

    public Riviste findRivisteById(long id) {
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
            System.out.println("Il prodotto è stato cancellato correttamente");
        } else {
            System.err.println("il Prodotto con l'id " + id + " non è stato trovato");
        }
    }
        public List<Catalogo> findByName (String titolo){
            // Alternativamente alla TypedQuery potrei utilizzare Query ma così non avrei certezza sui tipi
            TypedQuery<Catalogo> getProdottoByName = em.createNamedQuery("findByName", Catalogo.class);
            getProdottoByName.setParameter("titolo", titolo);
            return getProdottoByName.getResultList();
        }

        public List<Catalogo> findByNameStartsWith (String partialName){
            // Alternativamente alla TypedQuery potrei utilizzare Query ma così non avrei certezza sui tipi
            TypedQuery<Catalogo> getCatalogoByName = em.createNamedQuery("findByNameStartsWith", Catalogo.class);
            getCatalogoByName.setParameter("partialname", partialName);
            return getCatalogoByName.getResultList();
        }

        public List<Catalogo> findProducts() {
            TypedQuery<Catalogo> getAllQuery = em.createQuery("SELECT a FROM Catalogo a", Catalogo.class); // SELECT * FROM animals
            return getAllQuery.getResultList();
        }

        public List<Riviste> findRiviste () {
            TypedQuery<Riviste> getAllQuery = em.createQuery("SELECT d FROM riviste d", Riviste.class); // SELECT * FROM animals WHERE tipo_animale = 'Cane'
            return getAllQuery.getResultList();
        }

        public List<Libri> findBooks () {
            TypedQuery<Libri> getAllQuery = em.createQuery("SELECT c FROM libri c", Libri.class); // SELECT * FROM animals WHERE tipo_animale = 'Gatto'
            return getAllQuery.getResultList();
        }

        public List<String> findAllProducts () {
            TypedQuery<String> getAllQuery = em.createQuery("SELECT a.titolo FROM catalogo a", String.class); // SELECT name FROM animals
            return getAllQuery.getResultList();
        }

        public void findProdottiByNameAndUpdateName (String oldTitle, String newTitle){
            // Quando si parla di operazioni che vanno a modificare il db come save, update, delete devo usare le transazioni
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Query modifyNameQuery = em.createQuery("UPDATE Catalogo a SET a.titolo = :newName WHERE a.titolo = :oldTitle"); // UPDATE animals SET name = 'nuovonome' WHERE name = 'nomevecchio'
            modifyNameQuery.setParameter("newTitle", newTitle); // Non dimentichiamoci di settare i parametri della query altrimenti eccezione
            modifyNameQuery.setParameter("oldTitle", oldTitle);
            int numeroDiVolteModificato = modifyNameQuery.executeUpdate(); // Le query di update a differenza di quelle select restituiscono un numero intero che rappresenta quante righe ha aggiornato
            transaction.commit();

            if (numeroDiVolteModificato > 0) System.out.println("Volte modificato");
            else System.out.println("Non ho trovato nessun prodotto di nome " + oldTitle);

        }

        public void findProductsByNameAndDelete (String titolo){
            // Quando si parla di operazioni che vanno a modificare il db come save, update, delete devo usare le transazioni
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Query modifyNameQuery = em.createQuery("DELETE FROM Catalogo a WHERE a.titolo = :titolo"); // DELETE FROM animals WHERE name = 'nomedacancellare'
            modifyNameQuery.setParameter("titolo", titolo); // Non dimentichiamoci di settare i parametri della query altrimenti eccezione
            int numeroDiProdottiCancellati = modifyNameQuery.executeUpdate(); // Le query di update a differenza di quelle select restituiscono un numero intero che rappresenta quante righe ha aggiornato
            transaction.commit();

            if (numeroDiProdottiCancellati > 0) System.out.println("Prodotti eliminati");
            else System.out.println("Non ho trovato nessun prodotto di titolo " + titolo);

        }}




