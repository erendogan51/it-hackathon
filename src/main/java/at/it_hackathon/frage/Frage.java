package at.it_hackathon.frage;


import at.it_hackathon.enums.Schwierigkeit;
import at.it_hackathon.szenario.Szenario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Frage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String frage;

    @Enumerated(EnumType.STRING)
    private Schwierigkeit schwierigkeit;

    @ElementCollection
    private Set<String> antworten;

    private String richtigeAntwort;
    @Type(type = "text")
    private String erklaerung;

    public Frage(String frage, Schwierigkeit schwierigkeit, Set<String> antworten, String richtigeAntwort, String erklaerung) {
        this.frage = frage;
        this.schwierigkeit = schwierigkeit;
        this.antworten = antworten;
        this.antworten.add(richtigeAntwort);
        this.richtigeAntwort = richtigeAntwort;
        this.erklaerung = erklaerung;
    }
}
