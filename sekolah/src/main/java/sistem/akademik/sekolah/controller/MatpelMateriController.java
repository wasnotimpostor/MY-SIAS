package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.MatpelMateri;
import sistem.akademik.sekolah.security.service.MatpelMateriService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class MatpelMateriController {

    @Autowired
    private MatpelMateriService service;

    @RequestMapping(value = "/kurikulum",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<MatpelMateri> getAllFusion() {
        return service.getAllFusion();
    }

    @RequestMapping(value = "/kurikulum/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public MatpelMateri getFusion(@PathVariable Long id) {
        return service.getFusion(id);
    }

    @RequestMapping(value = "/kurikulum/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public MatpelMateri addFusion(@RequestBody MatpelMateri matpelMateri) {
        return service.addFusion(matpelMateri);
    }

    @RequestMapping(value = "/kurikulum",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public MatpelMateri deleteAllFusion(MatpelMateri matpelMateri) {
        return service.deleteAllFusion(matpelMateri);
    }

    @RequestMapping(value = "/kurikulum/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public MatpelMateri deleteFusion(@PathVariable Long id) {
        return service.deleteFusion(id);
    }
}
