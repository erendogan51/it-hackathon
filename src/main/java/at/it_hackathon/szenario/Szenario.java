package at.it_hackathon.szenario;


import at.it_hackathon.enums.Schwierigkeit;
import at.it_hackathon.frage.Frage;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Szenario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Frage> fragen;

    @Enumerated(EnumType.STRING)
    private Schwierigkeit schwierigkeit;

    @ElementCollection
    @Type(type = "text")
    private Set<String> absaetze;


    public Szenario(String name, Set<Frage> fragen, Schwierigkeit schwierigkeit) {
        this.fragen = fragen;
        this.schwierigkeit = schwierigkeit;
    }

    public void addFrageToSzenario(Frage frage){
        this.fragen.add(frage);
    }

    public void addListOfFragenToSzenario(List<Frage> fragen){
        this.fragen.addAll(fragen);
    }
}
