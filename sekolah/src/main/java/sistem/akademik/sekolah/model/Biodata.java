package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "biodata", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"no_identitas"})
})
public class Biodata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String no_identitas;

    private Long id_kelas;

    private String name;

    private String email;

    private String gender;

    private String jurusan;

    private String alamat;

    private String no_telp;

    private String pendidikan_terakhir;

    private String nilai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo_identitas() {
        return no_identitas;
    }

    public void setNo_identitas(String no_identitas) {
        this.no_identitas = no_identitas;
    }

    public Long getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(Long id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getPendidikan_terakhir() {
        return pendidikan_terakhir;
    }

    public void setPendidikan_terakhir(String pendidikan_terakhir) {
        this.pendidikan_terakhir = pendidikan_terakhir;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
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
}
