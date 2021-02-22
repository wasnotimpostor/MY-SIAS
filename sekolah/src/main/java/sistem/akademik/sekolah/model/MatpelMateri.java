package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "matpelmateri")
public class MatpelMateri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_matpel;

    private String materi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_matpel() {
        return id_matpel;
    }

    public void setId_matpel(Long id_matpel) {
        this.id_matpel = id_matpel;
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
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
