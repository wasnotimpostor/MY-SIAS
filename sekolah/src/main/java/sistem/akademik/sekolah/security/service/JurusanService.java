package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.Jurusan;
import sistem.akademik.sekolah.repository.JurusanRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class JurusanService {

    @Autowired
    private JurusanRepo jurusanRepo;

    public List<Jurusan> getAllJurusan() {
        List<Jurusan> jurusan = new ArrayList<>();
        jurusanRepo.findAll().forEach(jurusan::add);
        return jurusan;
    }

    public Jurusan getJurusan(Long id) {
        Jurusan jurusan = jurusanRepo.findById(id).orElse(null);
        return jurusan;
    }

    public Jurusan addJurusan(Jurusan jurusan) {
        jurusanRepo.save(jurusan);
        return jurusan;
    }

    public Jurusan deleteJurusan(Long id) {
        Jurusan jurusan = jurusanRepo.findById(id).orElse(null);
        jurusanRepo.deleteById(id);
        return jurusan;
    }

    public Jurusan deleteAllJurusan(Jurusan jurusan) {
        jurusanRepo.deleteAll();
        return jurusan;
    }

    public Jurusan updateJurusan(Long id, Jurusan jurusan) {
        jurusanRepo.save(jurusan);
        return jurusan;
    }
}
