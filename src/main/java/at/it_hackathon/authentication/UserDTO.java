package at.it_hackathon.authentication;


import at.it_hackathon.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {

    private final String username;
    private final String email;
    private final int points;


    public static UserDTO userToDTO(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getEmail(),
                user.getPoints()
                );
    }
}
