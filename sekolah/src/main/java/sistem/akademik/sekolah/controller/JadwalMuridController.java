package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.JadwalMurid;
import sistem.akademik.sekolah.model.User;
import sistem.akademik.sekolah.security.service.JadwalMuridService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class JadwalMuridController {

    @Autowired
    private JadwalMuridService jadwalMuridService;

    @RequestMapping(value = "/jadwalmurid",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<JadwalMurid> getAllJadwalMurid() {
        return jadwalMuridService.getAllJadwal();
    }

    @RequestMapping(value = "/jadwalmurid/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public JadwalMurid getJadwalMurid(@PathVariable Long id) {
        return jadwalMuridService.getJadwal(id);
    }

    @RequestMapping(value = "/jadwalmurid/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public JadwalMurid addJadwal(@RequestBody JadwalMurid jadwalMurid) {
        return jadwalMuridService.addJadwal(jadwalMurid);
    }

    @RequestMapping(value = "/jadwalmurid",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public JadwalMurid deleteAllJadwal(JadwalMurid jadwalMurid) {
        return jadwalMuridService.deleteAllJadwal(jadwalMurid);
    }

    @RequestMapping(value = "/jadwalmurid/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public JadwalMurid deleteJadwal(@PathVariable Long id) {
        return jadwalMuridService.deleteJadwal(id);
    }
}
