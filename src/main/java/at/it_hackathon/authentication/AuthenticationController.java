package at.it_hackathon.authentication;


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
    public String register(@RequestBody RegistrationRequest registrationRequest){
        return authenticationService.register(registrationRequest);
    }

    @PostMapping("/signin")
    public String register(@RequestBody SignInRequest signInRequest){
        return authenticationService.signIn(signInRequest);
    }
}
