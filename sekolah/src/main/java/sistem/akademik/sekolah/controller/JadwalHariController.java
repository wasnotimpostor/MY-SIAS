package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.JadwalHari;
import sistem.akademik.sekolah.security.service.JadwalHariService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class JadwalHariController {

    @Autowired
    private JadwalHariService jadwalHariService;

    @RequestMapping(value = "/jadwalhari",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<JadwalHari> getAllJadwalHari() {
        return jadwalHariService.getAllJadwalHari();
    }

    @RequestMapping(value = "/jadwalhari/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public JadwalHari getJadwalHari(@PathVariable Long id) {
        return jadwalHariService.getJadwalHari(id);
    }

    @RequestMapping(value = "/jadwalhari/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public JadwalHari addJadwalHari(@RequestBody JadwalHari jadwalHari) {
        return jadwalHariService.addJadwalHari(jadwalHari);
    }

    @RequestMapping(value = "/jadwalhari",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public JadwalHari deleteAllJadwalHari(JadwalHari jadwalHari) {
        return jadwalHariService.deleteAllJadwalHari(jadwalHari);
    }

    @RequestMapping(value = "/jadwalhari/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public JadwalHari deleteJadwalHari(@PathVariable Long id) {
        return jadwalHariService.deleteJadwalHari(id);
    }
}
