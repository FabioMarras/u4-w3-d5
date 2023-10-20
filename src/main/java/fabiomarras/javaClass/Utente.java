package fabiomarras.javaClass;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "User")
public class Utente {
    @Id
    @GeneratedValue
    private UUID tessera;
    private String nome;
    private String lastName;
    private LocalDate birthDate;


    @ManyToMany
    @JoinTable(name = "prestito_utente", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "prestito_id"))
    private Set<Prestito> prestito;

    public Utente(){}

    public Utente(String nome, String lastName, LocalDate birthDate) {
        this.nome = nome;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.prestito = prestito;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "tessera=" + tessera +
                ", nome='" + nome + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", prestito=" + prestito +
                '}';
    }
}
