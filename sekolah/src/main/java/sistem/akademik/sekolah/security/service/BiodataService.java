package sistem.akademik.sekolah.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistem.akademik.sekolah.model.Biodata;
import sistem.akademik.sekolah.repository.BiodataRepo;

@Service
public class BiodataService {
    
    @Autowired
    private BiodataRepo biodataRepo;

    public List<Biodata> getAllBiodata() {
        List<Biodata> biodata = new ArrayList<>();
        biodataRepo.findAll().forEach(biodata::add);
        return biodata;
    }

    public Biodata getBiodata(Long id) {
        Biodata biodata = biodataRepo.findById(id).orElse(null);
        return biodata;
    }

    public Biodata addBiodata(Biodata biodata) {
        biodataRepo.save(biodata);
        return biodata;
    }

    public Biodata deleteBiodata(Long id) {
        Biodata biodata = biodataRepo.findById(id).orElse(null);
        biodataRepo.deleteById(id);
        return biodata;
    }

    public Biodata deleteAllBiodata(Biodata biodata) {
        biodataRepo.deleteAll();
        return biodata;
    }

    public Biodata updateBiodata(Long id, Biodata biodata) {
        biodataRepo.save(biodata);
        return biodata;
    }
}
