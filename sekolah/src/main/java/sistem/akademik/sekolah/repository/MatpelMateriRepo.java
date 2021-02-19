package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.MatpelMateri;

@Repository
public interface MatpelMateriRepo extends JpaRepository<MatpelMateri, Long> {
}
