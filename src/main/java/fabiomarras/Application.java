package fabiomarras;

import com.github.javafaker.Faker;
import fabiomarras.fileDAO.LibroDAO;
import fabiomarras.fileDAO.RivisteDAO;
import fabiomarras.fileDAO.UtenteDAO;
import fabiomarras.javaClass.Libro;
import fabiomarras.javaClass.Riviste;
import fabiomarras.javaClass.Utente;
import fabiomarras.javaClass.periodicità;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;


public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");

        EntityManager em = emf.createEntityManager();
        try {
            LibroDAO ld = new LibroDAO(em);
            RivisteDAO rd = new RivisteDAO(em);
            UtenteDAO ud = new UtenteDAO(em);

            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();

           //SALVIAMO UN NUOVO LIBRO
            /*for (int l = 0; l < 15; l++) {
                Libro nuovoLibro = new Libro(faker.book().title(), rndm.nextInt(1000, 2024), rndm.nextInt(0, 100), faker.book().author(), faker.book().genre());
                ;

                nuovoLibro = em.merge(nuovoLibro);
                ld.save(nuovoLibro);
            }*/

            //SALVIAMO UNA NUOVA RIVISTA
            /*for (int i = 0; i < 15; i++) {
                Riviste nuovaRivista = new Riviste(faker.lorem().word(), rndm.nextInt(1000, 2024), rndm.nextInt(0, 100), periodicità.SEMESTRALE);
                nuovaRivista = em.merge(nuovaRivista);
                rd.save(nuovaRivista);
            }*/

            //SALVIAMO NUOVI UTENTI
            /*for (int i = 0; i < 15; i++) {
                Utente nuovoUtente = new Utente(faker.name().name(),faker.name().lastName(), LocalDate.now());
                nuovoUtente = em.merge(nuovoUtente);
                ud.save(nuovoUtente);
            }*/



        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
