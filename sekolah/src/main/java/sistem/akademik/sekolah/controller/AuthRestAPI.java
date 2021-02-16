package sistem.akademik.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sistem.akademik.sekolah.message.request.LoginForm;
import sistem.akademik.sekolah.message.request.RegisterForm;
import sistem.akademik.sekolah.message.response.JwtResponse;
import sistem.akademik.sekolah.model.*;
import sistem.akademik.sekolah.repository.*;
import sistem.akademik.sekolah.security.jwt.JwtProvider;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sekolah")
public class AuthRestAPI {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    BiodataRepo biodataRepo;

    @Autowired
    KelasRepo kelasRepo;

    @Autowired
    MateriRepo materiRepo;

    @Autowired
    HariRepo hariRepo;

    @Autowired
    JurusanRepo jurusanRepo;

     @Autowired
     JadwalMuridRepo jadwalMuridRepo;

     @Autowired
     RuangRepo ruangRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @RequestMapping(value = "/info", 
            produces = "application/json",
            method = RequestMethod.GET)
    @ResponseBody
    public Object currentUserName(Authentication authentication) {
        return authentication.getPrincipal();
    }

    @RequestMapping(value = "/register",
            produces = "application/json",
            method= RequestMethod.POST)
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterForm signUpRequest) {
        if (userRepo.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("GAGAL -> Username sudah dipakai", HttpStatus.BAD_REQUEST);
        }

        User user = new User(signUpRequest.getId_bio(), signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepo.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Role tidak ditemukan!"));
                    roles.add(adminRole);
                    break;
                case "guru":
                    Role guruRole = roleRepo.findByName(RoleName.ROLE_GURU)
                            .orElseThrow(() -> new RuntimeException("Role tidak ditemukan!"));
                    roles.add(guruRole);
                    break;
                default:
                    Role muridRole = roleRepo.findByName(RoleName.ROLE_MURID)
                            .orElseThrow(() -> new RuntimeException("Role tidak ditemukan!"));
                    roles.add(muridRole);
            }
        });

        user.setRoles(roles);
        userRepo.save(user);

        return ResponseEntity.ok().body("Register berhasil gaes!");
    }

    @RequestMapping(value = "/user/biodata/{id}",
            produces = "application/json",
            method= RequestMethod.PUT)
    public Biodata replaceBiodata(@RequestBody Biodata newBiodata, @PathVariable Long id) {
        return biodataRepo.findById(id).map(biodata -> {
            biodata.setNo_identitas(newBiodata.getNo_identitas());
            biodata.setName(newBiodata.getName());
            biodata.setEmail(newBiodata.getEmail());
            biodata.setGender(newBiodata.getGender());
            biodata.setJurusan(newBiodata.getJurusan());
            biodata.setAlamat(newBiodata.getAlamat());
            biodata.setNo_telp(newBiodata.getNo_telp());
            biodata.setPendidikan_terakhir(newBiodata.getPendidikan_terakhir());
            biodata.setNilai(newBiodata.getNilai());
            return biodataRepo.save(biodata);
        }) .orElseGet(() -> {
            newBiodata.setId(id);
            return biodataRepo.save(newBiodata);
        });
    }

    @RequestMapping(value = "/kelas/{id}",
            produces = "application/json",
            method= RequestMethod.PUT)
    public Kelas replaceKelas(@RequestBody Kelas newKelas, @PathVariable Long id) {
        return kelasRepo.findById(id).map(kelas -> {
            kelas.setKode_kelas(newKelas.getKode_kelas());
            kelas.setId_user(newKelas.getId_user());
            return kelasRepo.save(kelas);
        }) .orElseGet(() -> {
            newKelas.setId(id);
            return kelasRepo.save(newKelas);
        });
    }

     @RequestMapping(value = "/jadwalmurid/{id}",
             produces = "application/json",
             method= RequestMethod.PUT)
     public JadwalMurid replaceJadwal(@RequestBody JadwalMurid newJadwalMurid, @PathVariable Long id) {
         return jadwalMuridRepo.findById(id).map(jadwalMurid -> {
             jadwalMurid.setId_kelas(newJadwalMurid.getId_kelas());
             jadwalMurid.setId_hari(newJadwalMurid.getId_hari());
             jadwalMurid.setTanggal(newJadwalMurid.getTanggal());
             jadwalMurid.setJam(newJadwalMurid.getJam());
             jadwalMurid.setId_matpel(newJadwalMurid.getId_matpel());
             jadwalMurid.setId_ruang(newJadwalMurid.getId_ruang());
             jadwalMurid.setId_guru(newJadwalMurid.getId_guru());
             return jadwalMuridRepo.save(jadwalMurid);
         }) .orElseGet(() -> {
             newJadwalMurid.setId(id);
             return jadwalMuridRepo.save(newJadwalMurid);
         });
     }

     @RequestMapping(value = "/user/{id}",
             produces = "application/json",
             method= RequestMethod.PUT)
     public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
         return userRepo.findById(id).map(user -> {
             user.setId_bio(newUser.getId_bio());
             user.setUsername(newUser.getUsername());
             user.setPassword(newUser.getPassword());
             return userRepo.save(user);
         }) .orElseGet(() -> {
             newUser.setId(id);
             return userRepo.save(newUser);
         });
     }

     @RequestMapping(value = "/ruang/{id}",
             produces = "application/json",
             method= RequestMethod.PUT)
     public Ruang replaceRuang(@RequestBody Ruang newRuang, @PathVariable Long id) {
         return ruangRepo.findById(id).map(ruang -> {
             ruang.setName(newRuang.getName());
             return ruangRepo.save(ruang);
         }) .orElseGet(() -> {
             newRuang.setId(id);
             return ruangRepo.save(newRuang);
         });
     }

    @RequestMapping(value = "/materi/{id}",
            produces = "application/json",
            method= RequestMethod.PUT)
    public Materi replaceMateri(@RequestBody Materi newMateri, @PathVariable Long id) {
        return materiRepo.findById(id).map(materi -> {
            materi.setDeskripsi(newMateri.getDeskripsi());
            materi.setId_matpel(newMateri.getId_matpel());
            return materiRepo.save(materi);
        }) .orElseGet(() -> {
            newMateri.setId(id);
            return materiRepo.save(newMateri);
        });
    }

    @RequestMapping(value = "/hari/{id}",
            produces = "application/json",
            method= RequestMethod.PUT)
    public Hari replaceHari(@RequestBody Hari newHari, @PathVariable Long id) {
        return hariRepo.findById(id).map(hari -> {
            hari.setName(newHari.getName());
            return hariRepo.save(hari);
        }) .orElseGet(() -> {
            newHari.setId(id);
            return hariRepo.save(newHari);
        });
    }

    @RequestMapping(value = "/jurusan/{id}",
            produces = "application/json",
            method= RequestMethod.PUT)
    public Jurusan replaceJurusan(@RequestBody Jurusan newJurusan, @PathVariable Long id) {
        return jurusanRepo.findById(id).map(jurusan -> {
            jurusan.setName(newJurusan.getName());
            return jurusanRepo.save(jurusan);
        }) .orElseGet(() -> {
            newJurusan.setId(id);
            return jurusanRepo.save(newJurusan);
        });
    }
}
