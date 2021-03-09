package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.JadwalHari;
import sistem.akademik.sekolah.repository.JadwalHariRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class JadwalHariService {

    @Autowired
    private JadwalHariRepo jadwalHariRepo;

    public List<JadwalHari> getAllJadwalHari() {
        List<JadwalHari> jadwalHari = new ArrayList<>();
        jadwalHariRepo.findAll().forEach(jadwalHari::add);
        return jadwalHari;
    }

    public JadwalHari getJadwalHari(Long id) {
        JadwalHari jadwalHari = jadwalHariRepo.findById(id).orElse(null);
        return jadwalHari;
    }

    public JadwalHari addJadwalHari(JadwalHari jadwalHari) {
        jadwalHariRepo.save(jadwalHari);
        return jadwalHari;
    }

    public JadwalHari deleteJadwalHari(Long id) {
        JadwalHari jadwalHari = jadwalHariRepo.findById(id).orElse(null);
        jadwalHariRepo.deleteById(id);
        return jadwalHari;
    }

    public JadwalHari deleteAllJadwalHari(JadwalHari jadwalHari) {
        jadwalHariRepo.deleteAll();
        return jadwalHari;
    }
}
