package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.Ruang;
import sistem.akademik.sekolah.security.service.RuangService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class RuangController {

    @Autowired
    private RuangService ruangService;

    @RequestMapping(value = "/ruang",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<Ruang> getAllRuang() {
        return ruangService.getAllRuang();
    }

    @RequestMapping(value = "/ruang/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public Ruang getRuang(@PathVariable Long id) {
        return ruangService.getRuang(id);
    }

    @RequestMapping(value = "/ruang/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public Ruang addRuang(@RequestBody Ruang ruang) {
        return ruangService.addRuang(ruang);
    }

    @RequestMapping(value = "/ruang",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Ruang deleteAllRuang(Ruang ruang) {
        return ruangService.deleteAllRuang(ruang);
    }

    @RequestMapping(value = "/ruang/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Ruang deleteRuang(@PathVariable Long id) {
        return ruangService.deleteRuang(id);
    }
}
