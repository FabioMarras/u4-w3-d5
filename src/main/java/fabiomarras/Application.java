package fabiomarras;

import com.github.javafaker.Faker;
import fabiomarras.javaClass.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        System.out.println("Hello World!");

        Supplier<Libro> booksSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            return new Libro(faker.book().title(), rndm.nextInt(2000, 2024), rndm.nextInt(0, 100), faker.book().author(), faker.book().genre());
        };
        List<Libro> libri = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            libri.add(booksSupplier.get());
        }
        libri.forEach(System.out::println);
    }
}
