package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.Hari;

@Repository
public interface HariRepo extends JpaRepository<Hari, Long> {
}
