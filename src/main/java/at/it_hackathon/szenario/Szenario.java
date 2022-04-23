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

    @Type(type = "text")
    private String absatz1;
    @Type(type = "text")
    private String absatz2;
    @Type(type = "text")
    private String absatz3;
    @Type(type = "text")
    private String absatz4;
    @Type(type = "text")
    private String absatz5;
    @Type(type = "text")
    private String absatz6;
    @Type(type = "text")
    private String absatz7;
    @Type(type = "text")
    private String absatz8;
    @Type(type = "text")
    private String absatz9;
    @Type(type = "text")
    private String absatz10;


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
