package fabiomarras.javaClass;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
//Non ho trovato un gran senso nel creare un Inheritance
public class Prestito {

    @Id
    @GeneratedValue
    private UUID id;

    //private String Libro/rivista
    private LocalDate inizioPrestito;
    private LocalDate previstoFinePrestito;
    private LocalDate finePrestito;

    @ManyToMany
    @JoinTable(name = "prestito_utente", joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Utente> utente;
    @ManyToMany
    @JoinTable(name = "prestito_libro", joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private Set<Libro> libro;
    @ManyToMany
    @JoinTable(name = "prestito_riviste", joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "riviste_id"))
    private Set<Riviste> riviste;


    public Prestito(){}


    public Prestito(LocalDate inizioPrestito, LocalDate previstoFinePrestito, LocalDate finePrestito, Set<Libro> libro, Set<Riviste> riviste, Set<Utente> utente) {
        this.inizioPrestito = inizioPrestito;
        this.previstoFinePrestito = previstoFinePrestito;
        this.finePrestito = finePrestito;
        this.libro = libro;
        this.riviste = riviste;
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", inizioPrestito=" + inizioPrestito +
                ", previstoFinePrestito=" + previstoFinePrestito +
                ", finePrestito=" + finePrestito +
                ", utente=" + utente +
                '}';
    }
}
