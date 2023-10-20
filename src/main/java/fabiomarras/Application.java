package fabiomarras;

import com.github.javafaker.Faker;
import fabiomarras.fileDAO.LibroDAO;
import fabiomarras.fileDAO.RivisteDAO;
import fabiomarras.javaClass.Libro;
import fabiomarras.javaClass.Riviste;
import fabiomarras.javaClass.periodicità;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;
import java.util.Random;


public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");

        EntityManager em = emf.createEntityManager();
        try {
            LibroDAO ld = new LibroDAO(em);
            RivisteDAO rd = new RivisteDAO(em);

            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            Libro nuovoLibro = new Libro(faker.book().title(), rndm.nextInt(1000, 2024), rndm.nextInt(0, 100), faker.book().author(), faker.book().genre());;
            //SALVIAMO UN NUOVO LIBRO
            nuovoLibro = em.merge(nuovoLibro);
            //ld.save(nuovoLibro);

            //SALVIAMO UNA NUOVA RIVISTA
            Riviste nuovaRivista = new Riviste(faker.lorem().word(), rndm.nextInt(1000, 2024), rndm.nextInt(0, 100), periodicità.SEMESTRALE);
            nuovaRivista = em.merge(nuovaRivista);
            //rd.save(nuovaRivista);


        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
