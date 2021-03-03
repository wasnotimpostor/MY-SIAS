package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "murid")
public class Murid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
