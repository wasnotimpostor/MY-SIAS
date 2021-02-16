package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "materi")
public class Materi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deskripsi;

    private Long id_matpel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Long getId_matpel() {
        return id_matpel;
    }

    public void setId_matpel(Long id_matpel) {
        this.id_matpel = id_matpel;
    }

    @ManyToOne
    @JoinColumn(name = "id_matpel", referencedColumnName = "id", insertable = false, updatable = false)
    private MatPel matpel;

    public MatPel getMatpel() {
        return matpel;
    }

    public void setMatpel(MatPel matpel) {
        this.matpel = matpel;
    }
}
