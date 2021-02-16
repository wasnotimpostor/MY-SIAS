package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.MatPel;

@Repository
public interface MatpelRepo extends JpaRepository<MatPel, Long> {
}
