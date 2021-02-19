package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "matpelmateri")
public class MatpelMateri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_matpel;

    private Long id_materi;

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

    public Long getId_materi() {
        return id_materi;
    }

    public void setId_materi(Long id_materi) {
        this.id_materi = id_materi;
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
