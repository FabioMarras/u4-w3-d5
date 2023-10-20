package fabiomarras.fileDAO;

import fabiomarras.javaClass.Libro;
import fabiomarras.javaClass.Riviste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


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
