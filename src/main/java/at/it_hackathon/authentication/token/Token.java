package at.it_hackathon.authentication.token;


import at.it_hackathon.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdDateTime;

    @Column(nullable = false)
    private LocalDateTime expiresAtDateTime;


    private LocalDateTime confirmedDateTime;


    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public Token(String token, LocalDateTime createdDateTime, LocalDateTime expiresAtDateTime, User user) {
        this.token = token;
        this.createdDateTime = createdDateTime;
        this.expiresAtDateTime = expiresAtDateTime;
        this.user = user;
    }
}
