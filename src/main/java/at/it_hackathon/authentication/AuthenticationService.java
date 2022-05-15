package at.it_hackathon.authentication;


import at.it_hackathon.user.User;
import at.it_hackathon.user.UserRole;
import at.it_hackathon.user.UserService;
import at.it_hackathon.utils.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    private final AuthenticationManager authenticationManager;

    public String register(RegistrationRequest registrationRequest) {
        boolean isValid = emailValidator.isValid(registrationRequest.getEmail());
        if (!isValid) throw new IllegalStateException("email not valid");

        String token = userService.registerUser(
                new User(
                        registrationRequest.getUsername(),
                        registrationRequest.getEmail(),
                        registrationRequest.getPassword(),
                        UserRole.USER

                )
        );
        return token;
    }


    public String signIn(SignInRequest signInRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getUsernameOrEmail(), signInRequest.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return signInRequest.getUsernameOrEmail();
    }
}
