package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistem.akademik.sekolah.model.Kelas;

@Repository
public interface KelasRepo extends JpaRepository<Kelas, Long> {
    
}
