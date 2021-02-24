package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.Guru;
import sistem.akademik.sekolah.repository.GuruRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuruService {

    @Autowired
    private GuruRepo guruRepo;

    public List<Guru> getAllGuru() {
        List<Guru> guru = new ArrayList<>();
        guruRepo.findAll().forEach(guru::add);
        return guru;
    }

    public Guru getGuru(Long id) {
        Guru guru = guruRepo.findById(id).orElse(null);
        return guru;
    }

    public Guru addGuru(Guru guru) {
        guruRepo.save(guru);
        return guru;
    }

    public Guru deleteGuru(Long id) {
        Guru guru = guruRepo.findById(id).orElse(null);
        guruRepo.deleteById(id);
        return guru;
    }

    public Guru deleteAllGuru(Guru guru) {
        guruRepo.deleteAll();
        return guru;
    }
}
