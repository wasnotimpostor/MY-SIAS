package sistem.akademik.sekolah.message.request;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class RegisterForm {
    @NotBlank
    private String id_bio;

    @NotBlank
    private String username;

    private Set<String> role;

    @NotBlank
    private String password;

    public String getId_bio() {
        return id_bio;
    }

    public void setId_bio(String id_bio) {
        this.id_bio = id_bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}