package sistem.akademik.sekolah.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistem.akademik.sekolah.model.Kelas;
import sistem.akademik.sekolah.repository.KelasRepo;

@Service
public class KelasService {

    @Autowired
    private KelasRepo kelasRepo;

    public List<Kelas> getAllKelas() {
        List<Kelas> kelas = new ArrayList<>();
        kelasRepo.findAll().forEach(kelas::add);
        return kelas;
    }

    public Kelas getKelas(Long id) {
        Kelas kelas = kelasRepo.findById(id).orElse(null);
        return kelas;
    }

    public Kelas addKelas(Kelas kelas) {
        kelasRepo.save(kelas);
        return kelas;
    }

    public Kelas deleteKelas(Long id) {
        Kelas kelas = kelasRepo.findById(id).orElse(null);
        kelasRepo.deleteById(id);
        return kelas;
    }

    public Kelas deleteAllKelas(Kelas kelas) {
        kelasRepo.deleteAll();
        return kelas;
    }

    public Kelas updateUser(Long id, Kelas kelas) {
        kelasRepo.save(kelas);
        return kelas;
    }
}
