package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.Murid;
import sistem.akademik.sekolah.security.service.MuridService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class MuridController {

    @Autowired
    private MuridService muridService;

    @RequestMapping(value = "/murid",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<Murid> getAllMurid() {
        return muridService.getAllMurid();
    }

    @RequestMapping(value = "/murid/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public Murid getMurid(@PathVariable Long id) {
        return muridService.getMurid(id);
    }

    @RequestMapping(value = "/murid/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public Murid addMurid(@RequestBody Murid murid) {
        return muridService.addMurid(murid);
    }

    @RequestMapping(value = "/murid",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Murid deleteAllMurid(Murid murid) {
        return muridService.deleteAllMurid(murid);
    }

    @RequestMapping(value = "/murid/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Murid deleteMurid(@PathVariable Long id) {
        return muridService.deleteMurid(id);
    }
}
