package fabiomarras.javaClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

@Entity
@Table(name = "libri")
public class Libro {
    @Id
    @GeneratedValue
    private int codISBN;
    private String title;
    private int year;
    private int numPage;
    private String author;
    private String type;
    Random rndm = new Random();

    public Libro() {
    }

    public Libro(String title, int year, int numPage, String author, String type) {
        this.codISBN = rndm.nextInt(1000, 9900000);
        this.title = title;
        this.year = year;
        this.numPage = numPage;
        this.author = author;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codISBN=" + codISBN +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", numPage=" + numPage +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public int getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(int codISBN) {
        this.codISBN = codISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Random getRndm() {
        return rndm;
    }

    public void setRndm(Random rndm) {
        this.rndm = rndm;
    }
}
