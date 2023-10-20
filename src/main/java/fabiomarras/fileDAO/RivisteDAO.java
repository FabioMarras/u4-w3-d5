package fabiomarras.fileDAO;

import fabiomarras.javaClass.Libro;
import fabiomarras.javaClass.Riviste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class RivisteDAO {
    private  final EntityManager em;
    public RivisteDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(Riviste s){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(s);
        transaction.commit();
        System.out.println("Rivista registrata con successo!!");
    }

    //METODO FIND per codISBN
    public Riviste findById(int id){
        return em.find(Riviste.class, id);
    }

    //METODO FIND per anno
    public List<Riviste> findRivistePerYear(int year) {
        TypedQuery<Riviste> getAllQuery = em.createQuery("SELECT r FROM Riviste r WHERE r.year = :year", Riviste.class);
        List<Riviste> result = getAllQuery.setParameter("year", year).getResultList();
        System.out.println("Ecco le riviste del relativo anno: ");
        return getAllQuery.getResultList();
    }

    //FIND PER TITOLO
    public List<Riviste> findRivistePerTitle(String title) {
        TypedQuery<Riviste> getAllQuery = em.createQuery("SELECT r FROM Riviste r WHERE r.title LIKE CONCAT ('%', :title , '%')", Riviste.class);
        List<Riviste> result = getAllQuery.setParameter("title", title).getResultList();
        System.out.println("Ecco le riviste che contengono la parola da te scritta: ");
        return getAllQuery.getResultList();
    }

    //METODO DELETE per eliminare tramite codISBN
    public void findByIdAndDelete(int id){
        Riviste found = em.find(Riviste.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Rivista eliminata con successo!");
        }
    }
}
