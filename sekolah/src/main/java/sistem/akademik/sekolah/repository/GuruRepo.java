package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.Guru;

@Repository
public interface GuruRepo extends JpaRepository<Guru, Long> {
}
