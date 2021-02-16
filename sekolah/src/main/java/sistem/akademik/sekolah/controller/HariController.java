package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.Hari;
import sistem.akademik.sekolah.model.User;
import sistem.akademik.sekolah.security.service.HariService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class HariController {

    @Autowired
    private HariService hariService;

    @RequestMapping(value = "/hari",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<Hari> getAllHari() {
        return hariService.getAllHari();
    }

    @RequestMapping(value = "/hari/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public Hari getHari(@PathVariable Long id) {
        return hariService.getHari(id);
    }

    @RequestMapping(value = "/hari/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public Hari addHari(@RequestBody Hari hari) {
        return hariService.addHari(hari);
    }

    @RequestMapping(value = "/hari",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Hari deleteAllHari(Hari hari) {
        return hariService.deleteAllHari(hari);
    }

    @RequestMapping(value = "/hari/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Hari deleteHari(@PathVariable Long id) {
        return hariService.deleteHari(id);
    }
}
