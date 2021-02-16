package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.JadwalMurid;

@Repository
public interface JadwalMuridRepo extends JpaRepository<JadwalMurid, Long> {
}
