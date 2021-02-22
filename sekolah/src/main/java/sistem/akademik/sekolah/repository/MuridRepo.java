package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.Murid;

@Repository
public interface MuridRepo extends JpaRepository<Murid, Long> {
}
