package at.it_hackathon.frage;


import at.it_hackathon.szenario.Szenario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;

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
    private String antwort1;
    private String antwort2;
    private String richtigeAntwort;
    @Type(type = "text")
    private String erklaerung;
    @ManyToOne
    @JoinColumn(name = "szenario_id", nullable = true)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Szenario szenario;

    public Frage(String frage, String antwort1, String antwort2, String richtigeAntwort, Szenario szenario) {
        this.frage = frage;
        this.antwort1 = antwort1;
        this.antwort2 = antwort2;
        this.richtigeAntwort = richtigeAntwort;
        this.szenario=szenario;
    }

    public Frage(String frage, String antwort1, String antwort2, String richtigeAntwort) {
        this.frage = frage;
        this.antwort1 = antwort1;
        this.antwort2 = antwort2;
        this.richtigeAntwort = richtigeAntwort;
    }
}
