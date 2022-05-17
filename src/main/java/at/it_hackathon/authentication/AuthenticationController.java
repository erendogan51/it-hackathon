package at.it_hackathon.authentication;


import at.it_hackathon.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody RegistrationRequest registrationRequest){
        return authenticationService.register(registrationRequest);
    }

    @PostMapping("/signin")
    public UserDTO register(@RequestBody SignInRequest signInRequest){
        return authenticationService.signIn(signInRequest);
    }
}
