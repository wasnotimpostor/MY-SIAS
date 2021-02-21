package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.MatpelMateri;
import sistem.akademik.sekolah.model.User;
import sistem.akademik.sekolah.repository.MatpelMateriRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatpelMateriService {

    @Autowired
    private MatpelMateriRepo repo;

    public List<MatpelMateri> getAllFusion() {
        List<MatpelMateri> matpelMateri = new ArrayList<>();
        repo.findAll().forEach(matpelMateri::add);
        return matpelMateri;
    }

    public MatpelMateri getFusion(Long id) {
        MatpelMateri matpelMateri = repo.findById(id).orElse(null);
        return matpelMateri;
    }

    public MatpelMateri addFusion(MatpelMateri matpelMateri) {
        repo.save(matpelMateri);
        return matpelMateri;
    }

    public MatpelMateri deleteFusion(Long id) {
        MatpelMateri matpelMateri = repo.findById(id).orElse(null);
        repo.deleteById(id);
        return matpelMateri;
    }

    public MatpelMateri deleteAllFusion(MatpelMateri matpelMateri) {
        repo.deleteAll();
        return matpelMateri;
    }
}
