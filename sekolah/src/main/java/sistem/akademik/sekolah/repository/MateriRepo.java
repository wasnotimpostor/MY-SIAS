package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.Materi;

@Repository
public interface MateriRepo extends JpaRepository<Materi, Long> {
}
