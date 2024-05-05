package managment.assignment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUp {
    private String name;
    private String email;
    private String password;
    private String userType;
    private String profileHeadline;
    private String address;

    @Override
    public String toString() {
        return "SignUp{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", profileHeadline='" + profileHeadline + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
