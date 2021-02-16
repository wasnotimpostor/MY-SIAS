package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.MatPel;
import sistem.akademik.sekolah.model.User;
import sistem.akademik.sekolah.security.service.MatpelService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class MatpelController {

    @Autowired
    private MatpelService matpelService;

    @RequestMapping(value = "/matpel",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<MatPel> getAllUser() {
        return matpelService.getAllMatpel();
    }

    @RequestMapping(value = "/matpel/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public MatPel getMatpel(@PathVariable Long id) {
        return matpelService.getMatpel(id);
    }

    @RequestMapping(value = "/matpel/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public MatPel addMatpel(@RequestBody MatPel matpel) {
        return matpelService.addMatpel(matpel);
    }

    @RequestMapping(value = "/matpel",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public MatPel deleteAllMatpel(MatPel matpel) {
        return matpelService.deleteAllMatpel(matpel);
    }

    @RequestMapping(value = "/matpel/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public MatPel deleteMatpel(@PathVariable Long id) {
        return matpelService.deleteMatpel(id);
    }
}
