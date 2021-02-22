package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.Murid;
import sistem.akademik.sekolah.repository.MuridRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class MuridService {

    @Autowired
    private MuridRepo muridRepo;

    public List<Murid> getAllMurid() {
        List<Murid> murid = new ArrayList<>();
        muridRepo.findAll().forEach(murid::add);
        return murid;
    }

    public Murid getMurid(Long id) {
        Murid murid = muridRepo.findById(id).orElse(null);
        return murid;
    }

    public Murid addMurid(Murid murid) {
        muridRepo.save(murid);
        return murid;
    }

    public Murid deleteMurid(Long id) {
        Murid murid = muridRepo.findById(id).orElse(null);
        return murid;
    }

    public Murid deleteAllMurid(Murid murid) {
        muridRepo.deleteAll();
        return murid;
    }

    public Murid updateMurid(Long id, Murid murid) {
        muridRepo.save(murid);
        return murid;
    }
}
