package sistem.akademik.sekolah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sistem.akademik.sekolah.model.Kelas;
import sistem.akademik.sekolah.security.service.KelasService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class KelasController {

    @Autowired
    private KelasService kelasService;

    @RequestMapping(value = "/kelas",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<Kelas> getAllKelas() {
        return kelasService.getAllKelas();
    }

    @RequestMapping(value = "/kelas/{id}",
    produces = "application/json",
    method= RequestMethod.GET)
    public Kelas getKelas(@PathVariable Long id) {
        return kelasService.getKelas(id);
    }

    @RequestMapping(value = "/kelas/add",
    produces = "application/json",
    method= RequestMethod.POST)
    public Kelas addKelas(@RequestBody Kelas kelas) {
        return kelasService.addKelas(kelas);
    }

    @RequestMapping(value = "/kelas",
    produces = "application/json",
    method= RequestMethod.DELETE)
    public Kelas deleteAllKelas(Kelas kelas) {
        return kelasService.deleteAllKelas(kelas);
    }

    @RequestMapping(value = "/kelas/{id}",
    produces = "application/json",
    method= RequestMethod.DELETE)
    public Kelas deleteKelas(@PathVariable Long id) {
        return kelasService.deleteKelas(id);
    }
}
