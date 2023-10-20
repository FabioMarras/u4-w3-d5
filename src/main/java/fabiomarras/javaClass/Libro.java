package fabiomarras.javaClass;

import javax.persistence.*;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "libri")
@NamedQueries({@NamedQuery(name = "Libro.FindForYear",
        query = "SELECT l FROM Libro l WHERE l.year = :year")})
public class Libro {
    @Id
    @GeneratedValue
    private int codISBN;
    private String title;
    private int year;
    private int numPage;
    private String author;
    private String type;

    @ManyToMany
    @JoinTable(name = "prestito_libro", joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "prestito_id"))
    private Set<Prestito> prestito;

    public Libro() {
    }

    public Libro(String title, int year, int numPage, String author, String type) {
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

}
