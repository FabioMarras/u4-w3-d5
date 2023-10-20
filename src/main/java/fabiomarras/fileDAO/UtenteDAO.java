package fabiomarras.fileDAO;

import fabiomarras.javaClass.Riviste;
import fabiomarras.javaClass.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class UtenteDAO {
    private  final EntityManager em;
    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    //METODO SAVE
    public void save(Utente s){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(s);
        transaction.commit();
        System.out.println("Utente registrato con successo!!");
    }

    //METODO FIND per codISBN
    public Utente findById(int id){
        return em.find(Utente.class, id);
    }

    //METODO DELETE per eliminare tramite codISBN
    public void findByIdAndDelete(int id){
        Utente found = em.find(Utente.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Utente eliminato con successo!");
        }
    }
}
