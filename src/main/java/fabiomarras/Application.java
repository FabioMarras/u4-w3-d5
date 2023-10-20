package fabiomarras;

import com.github.javafaker.Faker;
import fabiomarras.fileDAO.LibroDAO;
import fabiomarras.fileDAO.PrestitoDAO;
import fabiomarras.fileDAO.RivisteDAO;
import fabiomarras.fileDAO.UtenteDAO;
import fabiomarras.javaClass.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.*;


public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");

        EntityManager em = emf.createEntityManager();
        try {
            LibroDAO ld = new LibroDAO(em);
            RivisteDAO rd = new RivisteDAO(em);
            UtenteDAO ud = new UtenteDAO(em);
            PrestitoDAO pd = new PrestitoDAO(em);

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

            //CERCHIAMO UN UTENTE
            Utente findUtente1 = ud.findById(UUID.fromString("231bedff-61fa-46b4-8edd-122bad570aac"));
            if (findUtente1 != null) {
                System.out.println(findUtente1);
            } else {
                System.out.println("non ho trovato niente");
            }
            Set<Utente> utenti2 = new HashSet<>();
            utenti2.add(findUtente1);

            Set<Utente> utenti = new HashSet<>();
            utenti.add(findUtente1);


            //CERCHIAMO UN LIBRO
            Libro findLibro1 = ld.findById(68);
            Libro findLibro2 = ld.findById(70);

            if (findLibro1 != null) {
                System.out.println(findLibro1);
            } else {
                System.out.println("non ho trovato niente");
            }
            Set<Libro> libri = new HashSet<>();
            libri.add(findLibro1);

            if (findLibro2 != null) {
                System.out.println(findLibro2);
            } else {
                System.out.println("non ho trovato niente");
            }
            Set<Libro> libri2 = new HashSet<>();
            libri2.add(findLibro1);
            libri2.add(findLibro2);

            //CERCHIAMO UNA RIVISTA
            Riviste findRivista1 = rd.findById(32);
            if (findRivista1 != null) {
                System.out.println(findRivista1);
            } else {
                System.out.println("non ho trovato niente");
            }
            Set<Riviste> riviste = new HashSet<>();
            riviste.add(findRivista1);


            //AGGIUNGO 30 GIORNI DALLA DATA DI IMMISSIONE LIBRO, FONTE:STACKOVERFLOW
            LocalDate oggi = LocalDate.now();
            LocalDate finePrestito = oggi.plusDays(30);

            //CREATO PRESTITO
            Prestito prestito = new Prestito(LocalDate.now(), finePrestito,null, libri , null, utenti);
            prestito = em.merge(prestito);
            //pd.save(prestito);

            Prestito prestito1 = new Prestito(LocalDate.now(), finePrestito,null, libri2 , null, utenti);
            prestito1 = em.merge(prestito1);
            //pd.save(prestito1);

            Prestito prestito2 = new Prestito(LocalDate.of(2023, 03,10), LocalDate.of(2023,04,10),LocalDate.now(), libri2 , riviste, utenti2);
            prestito2 = em.merge(prestito2);
            //pd.save(prestito2);

            //AGGIUNTA DI UN NUOVO ELEMENTO NEL CATALOGO LIBRI/RIVISTE
            Libro nuovoLibro = new Libro(faker.book().title(), rndm.nextInt(1000, 2024), rndm.nextInt(0, 100), faker.book().author(), faker.book().genre());
            Riviste nuovaRivista = new Riviste(faker.lorem().word(), rndm.nextInt(1000, 2024), rndm.nextInt(0, 100), periodicità.SEMESTRALE);

            nuovoLibro = em.merge(nuovoLibro);
            //ld.save(nuovoLibro); // COSI POSSIAMO SALVARE UN NUOVO LIBRO DESCRITTO SOPRA, NEL CATALOGO

            nuovaRivista = em.merge(nuovaRivista);
            //rd.save(nuovaRivista); // COSI POSSIAMO SALVARE UNA NUOVA RIVISTA DESCRITTA SOPRA, NEL CATALOGO

            //RIMOZIONE DI UN ELEMENTO DEL CATALOGO DATO UN CODICE ISBN
            //ld.findByIdAndDelete(78); // QUESTO è descritto in UtenteDAO
            //rd.findByIdAndDelete(78);

            //RICERCA PER ISBN
            Libro findLibro = ld.findById(68);
            if (findLibro != null) {
                System.out.println(findLibro);
            } else {
                System.out.println("non ho trovato niente");
            } // POSSIAMO RICERCARE PER ISBN E INSERIRE UN IF-ELSE PER AVERE UN MAGGIOR CONTROLLO

            //RICERCA PER ANNO
            ld.findLibriPerYear(1710).forEach(System.out::println);

            //RICERCA PER AUTORE
            ld.findLibriPerAuthor("Adriano Parisi").forEach(System.out::println);

            //RICERCA PER TITOLO O PARTE DI ESSO
            ld.findLibriPerTitle("the").forEach(System.out::println);

            //RICERCA ELEMENTI ATTUALMENTE IN PRESTITO CON UN NUMERO DI TESSERA PRECISO
            pd.findPrestitiScadutoUtente(UUID.fromString("10cba43c-d7bf-4619-ae28-07d244fc6621")).forEach(System.out::println);

            //RICERCA PRESTITI SCADUTI IN GENERALE
            pd.findPrestitiScaduto().forEach(System.out::println);

            //NAMEDQUERIES RIGUARDANTE UNA RICERCA PER ANNO
            TypedQuery<Libro> getAllQuery = em.createNamedQuery("Libro.FindForYear", Libro.class);
            getAllQuery.setParameter("year", 1530);

            List<Libro> result = getAllQuery.getResultList();

            System.out.println("Ecco i libri dell'anno: " + 1530 + " da te richiesto: ");
            result.forEach(System.out::println);

        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
