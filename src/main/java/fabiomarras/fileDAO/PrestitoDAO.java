package fabiomarras.fileDAO;

import fabiomarras.javaClass.Libro;
import fabiomarras.javaClass.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


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
