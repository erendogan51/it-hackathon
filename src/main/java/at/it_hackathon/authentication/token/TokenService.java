package at.it_hackathon.authentication.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;


    public void saveToken(Token token){
        tokenRepository.save(token);
    }

}
