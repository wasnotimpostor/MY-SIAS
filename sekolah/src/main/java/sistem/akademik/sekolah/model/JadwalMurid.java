package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "jadwal_murid")
public class JadwalMurid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_kelas;

    private Long id_hari;

    private String tanggal;

    private String jam;

    private Long id_matpel;

    private Long id_ruang;

    private Long id_guru;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(Long id_kelas) {
        this.id_kelas = id_kelas;
    }

    public Long getId_hari() {
        return id_hari;
    }

    public void setId_hari(Long id_hari) {
        this.id_hari = id_hari;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public Long getId_matpel() {
        return id_matpel;
    }

    public void setId_matpel(Long id_matpel) {
        this.id_matpel = id_matpel;
    }

    public Long getId_ruang() {
        return id_ruang;
    }

    public void setId_ruang(Long id_ruang) {
        this.id_ruang = id_ruang;
    }

    public Long getId_guru() {
        return id_guru;
    }

    public void setId_guru(Long id_guru) {
        this.id_guru = id_guru;
    }

    @ManyToOne
    @JoinColumn(name = "id_ruang", referencedColumnName = "id", insertable = false, updatable = false)
    private Ruang ruang;

    public Ruang getRuang() {
        return ruang;
    }

    public void setRuang(Ruang ruang) {
        this.ruang = ruang;
    }

    @ManyToOne
    @JoinColumn(name = "id_guru", referencedColumnName = "id", insertable = false, updatable = false)
    private Biodata biodata;

    public Biodata getBiodata() {
        return biodata;
    }

    public void setBiodata(Biodata biodata) {
        this.biodata = biodata;
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
    @JoinColumn(name = "id_kelas", referencedColumnName = "id", insertable = false, updatable = false)
    private Kelas kelas;

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
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
}
