package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.JadwalMurid;
import sistem.akademik.sekolah.model.User;
import sistem.akademik.sekolah.repository.JadwalMuridRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class JadwalMuridService {

    @Autowired
    private JadwalMuridRepo jadwalMuridRepo;

    public List<JadwalMurid> getAllJadwal() {
        List<JadwalMurid> jadwalMurid = new ArrayList<>();
        jadwalMuridRepo.findAll().forEach(jadwalMurid::add);
        return jadwalMurid;
    }

    public JadwalMurid getJadwal(Long id) {
        JadwalMurid jadwalMurid = jadwalMuridRepo.findById(id).orElse(null);
        return jadwalMurid;
    }

    public JadwalMurid addJadwal(JadwalMurid jadwalMurid) {
        jadwalMuridRepo.save(jadwalMurid);
        return jadwalMurid;
    }

    public JadwalMurid deleteJadwal(Long id) {
        JadwalMurid jadwalMurid = jadwalMuridRepo.findById(id).orElse(null);
        jadwalMuridRepo.deleteById(id);
        return jadwalMurid;
    }

    public JadwalMurid deleteAllJadwal(JadwalMurid jadwalMurid) {
        jadwalMuridRepo.deleteAll();
        return jadwalMurid;
    }

    public JadwalMurid updateJadwal(Long id, JadwalMurid jadwalMurid) {
        jadwalMuridRepo.save(jadwalMurid);
        return jadwalMurid;
    }
}
