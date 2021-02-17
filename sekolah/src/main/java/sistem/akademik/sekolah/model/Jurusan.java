package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "jurusan")
public class Jurusan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long id_matpel;

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

    public Long getId_matpel() {
        return id_matpel;
    }

    public void setId_matpel(Long id_matpel) {
        this.id_matpel = id_matpel;
    }

    @ManyToOne
    @JoinColumn(name = "id_matpel", referencedColumnName = "id", insertable = false, updatable = false)
    private MatPel matPel;

    public MatPel getMatPel() {
        return matPel;
    }

    public void setMatPel(MatPel matPel) {
        this.matPel = matPel;
    }
}
