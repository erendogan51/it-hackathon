package at.it_hackathon.user;

import at.it_hackathon.authentication.token.Token;
import at.it_hackathon.authentication.token.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final TokenService tokenService;
    private final String USER_NOT_FOUND_MSG = "user was not found";




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG));
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email).get();
    }


    public String registerUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) throw new IllegalStateException("email already in use");

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        String createdToken = UUID.randomUUID().toString();

        Token token = new Token(
                createdToken,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                user
        );

        tokenService.saveToken(token);

        return createdToken;
    }


}
