package fabiomarras.fileDAO;

import fabiomarras.javaClass.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class LibroDAO {
    private  final EntityManager em;
    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(Libro s){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(s);
        transaction.commit();
        System.out.println("Libro registrato con successo!!");
    }

    //METODO FIND per codISBN
    public Libro findById(int id){
        return em.find(Libro.class, id);
    }

    //METODO FIND per anno
    public List<Libro> findLibriPerYear(int year) {
        TypedQuery<Libro> getAllQuery = em.createQuery("SELECT l FROM Libro l WHERE l.year = :year", Libro.class);
        List<Libro> result = getAllQuery.setParameter("year", year).getResultList();
        System.out.println("Ecco i Libri del relativo anno: ");
        return getAllQuery.getResultList();
    }

    //FIND PER ATTORE
    public List<Libro> findLibriPerAuthor(String author) {
        TypedQuery<Libro> getAllQuery = em.createQuery("SELECT l FROM Libro l WHERE l.author = :author", Libro.class);
        List<Libro> result = getAllQuery.setParameter("author", author).getResultList();
        System.out.println("Ecco i Libri del relativo autore: ");
        return getAllQuery.getResultList();
    }

    //FIND PER TITOLO
    public List<Libro> findLibriPerTitle(String title) {
        TypedQuery<Libro> getAllQuery = em.createQuery("SELECT l FROM Libro l WHERE l.title LIKE CONCAT ('%', :title , '%')", Libro.class);
        List<Libro> result = getAllQuery.setParameter("title", title).getResultList();
        System.out.println("Ecco i Libri che contengono la parola da te scritta: ");
        return getAllQuery.getResultList();
    }

    //METODO DELETE per eliminare tramite codISBN
    public void findByIdAndDelete(int id){
        Libro found = em.find(Libro.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Libro eliminato con successo!");
        }
    }
}
