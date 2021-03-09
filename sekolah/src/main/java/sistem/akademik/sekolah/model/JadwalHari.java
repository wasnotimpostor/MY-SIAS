package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "jadwal_hari")
public class JadwalHari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_hari;

    private Long id_jadwal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_hari() {
        return id_hari;
    }

    public void setId_hari(Long id_hari) {
        this.id_hari = id_hari;
    }

    public Long getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(Long id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    @ManyToOne
    @JoinColumn(name = "id_hari", referencedColumnName = "id", insertable = false, updatable = false)
    private Hari hari;

    public Hari getHari() {
        return hari;
    }

    public void setHari(Hari hari) {
        this.hari = hari;
    }

    @ManyToOne
    @JoinColumn(name = "id_jadwal", referencedColumnName = "id", insertable = false, updatable = false)
    private JadwalMurid jadwalMurid;

    public JadwalMurid getJadwalMurid() {
        return jadwalMurid;
    }

    public void setJadwalMurid(JadwalMurid jadwalMurid) {
        this.jadwalMurid = jadwalMurid;
    }
}
