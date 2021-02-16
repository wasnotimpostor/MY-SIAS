package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.Hari;
import sistem.akademik.sekolah.repository.HariRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class HariService {
    
    @Autowired
    private HariRepo hariRepo;

    public List<Hari> getAllHari() {
        List<Hari> hari = new ArrayList<>();
        hariRepo.findAll().forEach(hari::add);
        return hari;
    }

    public Hari getHari(Long id) {
        Hari hari = hariRepo.findById(id).orElse(null);
        return hari;
    }

    public Hari addHari(Hari hari) {
        hariRepo.save(hari);
        return hari;
    }

    public Hari deleteHari(Long id) {
        Hari hari = hariRepo.findById(id).orElse(null);
        hariRepo.deleteById(id);
        return hari;
    }

    public Hari deleteAllHari(Hari hari) {
        hariRepo.deleteAll();
        return hari;
    }

    public Hari updateHari(Long id, Hari hari) {
        hariRepo.save(hari);
        return hari;
    }
}
