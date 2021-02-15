package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.Ruang;
import sistem.akademik.sekolah.repository.RuangRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuangService {

    @Autowired
    private RuangRepo ruangRepo;

    public List<Ruang> getAllRuang() {
        List<Ruang> ruang = new ArrayList<>();
        ruangRepo.findAll().forEach(ruang::add);
        return ruang;
    }

    public Ruang getRuang(Long id) {
        Ruang ruang = ruangRepo.findById(id).orElse(null);
        return ruang;
    }

    public Ruang addRuang(Ruang ruang) {
        ruangRepo.save(ruang);
        return ruang;
    }

    public Ruang deleteRuang(Long id) {
        Ruang ruang = ruangRepo.findById(id).orElse(null);
        ruangRepo.deleteById(id);
        return ruang;
    }

    public Ruang deleteAllRuang(Ruang ruang) {
        ruangRepo.deleteAll();
        return ruang;
    }

    public Ruang updateRuang(Long id, Ruang ruang) {
        ruangRepo.save(ruang);
        return ruang;
    }
}
