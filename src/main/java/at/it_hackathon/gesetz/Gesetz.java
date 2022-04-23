package at.it_hackathon.gesetz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Gesetz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String artikel;
    private String paragraph;
    private String gesetzBuch;
    @Type(type = "text")
    private String inhalt;

    public Gesetz(int artikel, int paragraph, String gesetzBuch, String inhalt) {
        this.artikel = "Art. " + artikel;
        this.paragraph = "§ " + paragraph;
        this.gesetzBuch = gesetzBuch;
        this.inhalt = inhalt;
    }


}
