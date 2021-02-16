package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.Materi;
import sistem.akademik.sekolah.repository.MateriRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriService {

    @Autowired
    private MateriRepo materiRepo;

    public List<Materi> getAllMateri() {
        List<Materi> materi = new ArrayList<>();
        materiRepo.findAll().forEach(materi::add);
        return materi;
    }

    public Materi getMateri(Long id) {
        Materi materi = materiRepo.findById(id).orElse(null);
        return materi;
    }

    public Materi addMateri(Materi materi) {
        materiRepo.save(materi);
        return materi;
    }

    public Materi deleteMateri(Long id) {
        Materi materi = materiRepo.findById(id).orElse(null);
        materiRepo.deleteById(id);
        return materi;
    }

    public Materi deleteAllMateri(Materi materi) {
        materiRepo.deleteAll();
        return materi;
    }

    public Materi updateMateri(Long id, Materi materi) {
        materiRepo.save(materi);
        return materi;
    }
}
