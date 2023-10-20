package fabiomarras.javaClass;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "riviste")
public class Riviste {

    @Id
    @GeneratedValue
    private int codISBN;
    private String title;
    private int year;
    private int numPage;
    @Enumerated(EnumType.STRING)
    private periodicità periodicitàEnum;


    public Riviste() {
    }
    Random rndm = new Random();

    public Riviste(String title, int year, int numPage, periodicità periodicitàEnum) {
        this.codISBN = rndm.nextInt(1000, 9900000);
        this.title = title;
        this.year = year;
        this.numPage = numPage;
        this.periodicitàEnum = periodicitàEnum;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "codISBN=" + codISBN +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", numPage=" + numPage +
                ", periodicitàEnum=" + periodicitàEnum +
                '}';
    }

    public int getCodISBN() {
        return codISBN;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public int getNumPage() {
        return numPage;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }


    public fabiomarras.javaClass.periodicità getPeriodicitàEnum() {
        return periodicitàEnum;
    }

    public void setPeriodicitàEnum(fabiomarras.javaClass.periodicità periodicitàEnum) {
        this.periodicitàEnum = periodicitàEnum;
    }
}
