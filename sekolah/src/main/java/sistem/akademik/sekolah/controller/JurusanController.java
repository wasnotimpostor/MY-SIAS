package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.Jurusan;
import sistem.akademik.sekolah.model.User;
import sistem.akademik.sekolah.security.service.JurusanService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class JurusanController {

    @Autowired
    private JurusanService jurusanService;

    @RequestMapping(value = "/jurusan",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<Jurusan> getAllJurusan() {
        return jurusanService.getAllJurusan();
    }

    @RequestMapping(value = "/jurusan/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public Jurusan getJurusan(@PathVariable Long id) {
        return jurusanService.getJurusan(id);
    }

    @RequestMapping(value = "/jurusan/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public Jurusan addJurusan(@RequestBody Jurusan jurusan) {
        return jurusanService.addJurusan(jurusan);
    }

    @RequestMapping(value = "/jurusan",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Jurusan deleteAllJurusan(Jurusan jurusan) {
        return jurusanService.deleteAllJurusan(jurusan);
    }

    @RequestMapping(value = "/jurusan/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public Jurusan deleteJurusan(@PathVariable Long id) {
        return jurusanService.deleteJurusan(id);
    }
}
