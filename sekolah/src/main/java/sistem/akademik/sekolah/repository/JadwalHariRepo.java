package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.JadwalHari;

@Repository
public interface JadwalHariRepo extends JpaRepository<JadwalHari, Long> {
}
