package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.MatPel;
import sistem.akademik.sekolah.repository.MatpelRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatpelService {

    @Autowired
    private MatpelRepo matpelRepo;

    public List<MatPel> getAllMatpel() {
        List<MatPel> matpel = new ArrayList<>();
        matpelRepo.findAll().forEach(matpel::add);
        return matpel;
    }

    public MatPel getMatpel(Long id) {
        MatPel matpel = matpelRepo.findById(id).orElse(null);
        return matpel;
    }

    public MatPel addMatpel(MatPel matpel) {
        matpelRepo.save(matpel);
        return matpel;
    }

    public MatPel deleteMatpel(Long id) {
        MatPel matpel = matpelRepo.findById(id).orElse(null);
        matpelRepo.deleteById(id);
        return matpel;
    }

    public MatPel deleteAllMatpel(MatPel matpel) {
        matpelRepo.deleteAll();
        return matpel;
    }

    public MatPel updateMatpel(Long id, MatPel matpel) {
        matpelRepo.save(matpel);
        return matpel;
    }
}
