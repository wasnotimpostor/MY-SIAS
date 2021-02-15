package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.Ruang;

@Repository
public interface RuangRepo extends JpaRepository<Ruang, Long> {
}
