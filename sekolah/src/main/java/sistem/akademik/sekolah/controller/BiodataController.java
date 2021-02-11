package sistem.akademik.sekolah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sistem.akademik.sekolah.model.Biodata;
import sistem.akademik.sekolah.security.service.BiodataService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class BiodataController {
    
    @Autowired
    private BiodataService biodataService;

    @RequestMapping(value = "/user/biodata",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<Biodata> getAllBiodata() {
        return biodataService.getAllBiodata();
    }

    @RequestMapping(value = "/user/biodata/{id}",
    produces = "application/json",
    method= RequestMethod.GET)
    public Biodata getBiodata(@PathVariable Long id) {
        return biodataService.getBiodata(id);
    }

    @RequestMapping(value = "/user/biodata/add",
    produces = "application/json",
    method= RequestMethod.POST)
    public Biodata addBiodata(@RequestBody Biodata biodata) {
        return biodataService.addBiodata(biodata);
    }

    @RequestMapping(value = "/user/biodata",
    produces = "application/json",
    method= RequestMethod.DELETE)
    public Biodata deleteAllBiodata(Biodata biodata) {
        return biodataService.deleteAllBiodata(biodata);
    }

    @RequestMapping(value = "/user/biodata/{id}",
    produces = "application/json",
    method= RequestMethod.DELETE)
    public Biodata deleteBiodata(@PathVariable Long id) {
        return biodataService.deleteBiodata(id);
    }
}
