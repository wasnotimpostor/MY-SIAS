package sistem.akademik.sekolah.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistem.akademik.sekolah.model.User;
import sistem.akademik.sekolah.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUser() {
        List<User> user = new ArrayList<>();
        userRepo.findAll().forEach(user::add);
        return user;
    }

    public User getUser(Long id) {
        User user = userRepo.findById(id).orElse(null);
        return user;
    }

    public User addUser(User user) {
        userRepo.save(user);
        return user;
    }

    public User deleteUser(Long id) {
        User user = userRepo.findById(id).orElse(null);
        userRepo.deleteById(id);
        return user;
    }

    public User deleteAllUser(User user) {
        userRepo.deleteAll();
        return user;
    }

    public User updateUser(Long id, User user) {
        userRepo.save(user);
        return user;
    }
}
