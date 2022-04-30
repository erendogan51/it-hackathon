package at.it_hackathon.frage;


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

    @ElementCollection
    private Set<String> antworten;

    private String richtigeAntwort;
    @Type(type = "text")
    private String erklaerung;

    @ManyToOne
    @JoinColumn(name = "szenario_id", nullable = true)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Szenario szenario;

    public Frage(String frage, Set<String> antworten, String richtigeAntwort, String erklaerung, Szenario szenario) {
        this.frage = frage;
        this.antworten = antworten;
        this.richtigeAntwort = richtigeAntwort;
        this.erklaerung = erklaerung;
        this.szenario = szenario;
    }

    public Frage(String frage, Set<String> antworten, String richtigeAntwort, String erklaerung) {
        this.frage = frage;
        this.antworten = antworten;
        this.richtigeAntwort = richtigeAntwort;
        this.erklaerung = erklaerung;
    }
}
