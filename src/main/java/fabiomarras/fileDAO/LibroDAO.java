package fabiomarras.fileDAO;

import fabiomarras.javaClass.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


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
