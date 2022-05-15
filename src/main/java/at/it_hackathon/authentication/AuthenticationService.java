package at.it_hackathon.authentication;


import at.it_hackathon.user.User;
import at.it_hackathon.user.UserRole;
import at.it_hackathon.user.UserService;
import at.it_hackathon.utils.EmailValidator;
import lombok.AllArgsConstructor;
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

    public UserDTO register(RegistrationRequest registrationRequest) {
        boolean isValid = emailValidator.isValid(registrationRequest.getEmail());
        if (!isValid) throw new IllegalStateException("email not valid");
        User user = new User(
                registrationRequest.getUsername(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                UserRole.USER

        );
        String token = userService.registerUser(user);
        user.setPassword(null);

        return UserDTO.userToDTO(user);
    }


    public UserDTO signIn(SignInRequest signInRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getEmail(), signInRequest.getPassword()
        ));


        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userService.findUserByEmail(signInRequest.getEmail());
        user.setPassword(null);

        return UserDTO.userToDTO(user);
    }
}
