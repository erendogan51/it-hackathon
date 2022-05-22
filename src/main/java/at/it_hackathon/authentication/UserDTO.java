package at.it_hackathon.authentication;


import at.it_hackathon.user.User;
import at.it_hackathon.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {

    private final Long id;
    private final String username;
    private final String email;
    private final int points;

    private final UserRole userRole;


    public static UserDTO userToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPoints(),
                user.getUserRole()
                );
    }
}
