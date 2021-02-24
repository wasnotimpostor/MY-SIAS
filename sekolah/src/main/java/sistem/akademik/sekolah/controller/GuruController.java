package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.Guru;
import sistem.akademik.sekolah.security.service.GuruService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class GuruController {

    @Autowired
    private GuruService guruService;

    @RequestMapping(value = "/guru",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<Guru> getAllGuru() {
        return guruService.getAllGuru();
    }

    @RequestMapping(value = "/guru/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public Guru getGuru(@PathVariable Long id) {
        return guruService.getGuru(id);
    }

    @RequestMapping(value = "/guru",
            produces = "application/json",
            method= RequestMethod.POST)
    public Guru addGuru(@RequestBody Guru guru) {
        return guruService.addGuru(guru);
    }

    @RequestMapping(value = "/guru",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Guru deleteAllGuru(Guru guru) {
        return guruService.deleteAllGuru(guru);
    }

    @RequestMapping(value = "/guru/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Guru deleteGuru(@PathVariable Long id) {
        return guruService.deleteGuru(id);
    }
}
