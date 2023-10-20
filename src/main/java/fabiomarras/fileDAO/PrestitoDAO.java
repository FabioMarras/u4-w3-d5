package fabiomarras.fileDAO;

import fabiomarras.javaClass.Libro;
import fabiomarras.javaClass.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.UUID;


public class PrestitoDAO {
    private  final EntityManager em;
    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(Prestito s){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(s);
        transaction.commit();
        System.out.println("Prestito registrato con successo!!");
    }

    //METODO FIND per codISBN
    public Prestito findById(int id){
        return em.find(Prestito.class, id);
    }

    //RICERCA ELEMENTI ATTUALMENTE IN PRESTITO E SCADUTI
    public List<Prestito> findPrestitiScaduto() {
        LocalDate oggi = LocalDate.now();
        TypedQuery<Prestito> getAllQuery = em.createQuery("SELECT p FROM Prestito p WHERE p.previstoFinePrestito < :oggi", Prestito.class);
        getAllQuery.setParameter("oggi", oggi);
        System.out.println("Ecco i prestiti scaduti: ");
        return getAllQuery.getResultList();
    }


    //RICERCA ELEMENTI ATTUALMENTE IN PRESTITO CON UN NUMERO DI TESSERA PRECISO
    public List<Prestito> findPrestitiScadutoUtente(UUID userId) {
        LocalDate oggi = LocalDate.now();
        TypedQuery<Prestito> getAllQuery = em.createQuery("SELECT p FROM Prestito p " + "JOIN p.utente u " + "WHERE p.previstoFinePrestito < :oggi AND u.id = :userId", Prestito.class);
        getAllQuery.setParameter("userId", userId);
        getAllQuery.setParameter("oggi", oggi);
        System.out.println("Ecco i prestiti scaduti dell'utente: " + userId + " nella data odierna: " + LocalDate.now());
        return getAllQuery.getResultList();
    }


    //METODO DELETE per eliminare tramite codISBN
    public void findByIdAndDelete(int id){
        Prestito found = em.find(Prestito.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Prestito eliminato con successo!");
        }
    }
}
