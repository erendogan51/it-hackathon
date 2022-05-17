package at.it_hackathon.authentication;


import lombok.Getter;

@Getter
public class SignInRequest {

    private final String email;
    private final String password;

    public SignInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
