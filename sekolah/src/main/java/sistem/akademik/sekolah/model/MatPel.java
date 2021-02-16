package sistem.akademik.sekolah.model;

import javax.persistence.*;

@Entity
@Table(name = "matpel")
public class MatPel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long id_jurusan;

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

    public Long getId_jurusan() {
        return id_jurusan;
    }

    public void setId_jurusan(Long id_jurusan) {
        this.id_jurusan = id_jurusan;
    }

    @ManyToOne
    @JoinColumn(name = "id_jurusan", referencedColumnName = "id", insertable = false, updatable = false)
    private Jurusan jurusan;

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }
}
