package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.Materi;
import sistem.akademik.sekolah.model.User;
import sistem.akademik.sekolah.security.service.MateriService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class MateriController {

    @Autowired
    private MateriService materiService;

    @RequestMapping(value = "/materi",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<Materi> getAllMateri() {
        return materiService.getAllMateri();
    }

    @RequestMapping(value = "/materi/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public Materi getMateri(@PathVariable Long id) {
        return materiService.getMateri(id);
    }

    @RequestMapping(value = "/materi/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public Materi addMateri(@RequestBody Materi materi) {
        return materiService.addMateri(materi);
    }

    @RequestMapping(value = "/materi",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Materi deleteAllMateri(Materi materi) {
        return materiService.deleteAllMateri(materi);
    }

    @RequestMapping(value = "/materi/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Materi deleteMateri(@PathVariable Long id) {
        return materiService.deleteMateri(id);
    }
}
