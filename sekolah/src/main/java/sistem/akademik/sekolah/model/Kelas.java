package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "kelas")
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kode_kelas;

    private Long id_user;

    private Long id_jadwal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(Long id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
    private Biodata biodata;

    public Biodata getBiodata() {
        return biodata;
    }

    public void setBiodata(Biodata biodata) {
        this.biodata = biodata;
    }

    @OneToOne
    @JoinColumn(name = "id_jadwal", referencedColumnName = "id", insertable = false, updatable = false)
    private JadwalMurid jadwalMurid;

    public JadwalMurid getJadwalMurid() {
        return jadwalMurid;
    }

    public void setJadwalMurid(JadwalMurid jadwalMurid) {
        this.jadwalMurid = jadwalMurid;
    }
}
