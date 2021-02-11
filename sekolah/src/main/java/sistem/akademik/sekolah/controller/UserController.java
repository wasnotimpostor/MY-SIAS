package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.model.User;
import sistem.akademik.sekolah.security.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sekolah")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",
            produces = "application/json",
            method= RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/user/{id}",
            produces = "application/json",
            method= RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public User deleteAllUser(User user) {
        return userService.deleteAllUser(user);
    }

    @RequestMapping(value = "/user/{id}",
            produces = "application/json",
            method= RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
