package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "matpel")
public class MatPel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long id_materi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_materi() {
        return id_materi;
    }

    public void setId_materi(Long id_materi) {
        this.id_materi = id_materi;
    }

    @ManyToOne
    @JoinColumn(name = "id_materi", referencedColumnName = "id", insertable = false, updatable = false)
    private Materi materi;

    public Materi getMateri() {
        return materi;
    }

    public void setMateri(Materi materi) {
        this.materi = materi;
    }
}
