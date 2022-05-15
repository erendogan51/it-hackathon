package at.it_hackathon.authentication;


import lombok.Getter;

@Getter

public class SignInRequest {

    private final String usernameOrEmail;
    private final String password;

    public SignInRequest(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

}
