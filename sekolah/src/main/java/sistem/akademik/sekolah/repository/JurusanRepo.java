package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.Jurusan;

@Repository
public interface JurusanRepo extends JpaRepository<Jurusan, Long> {
}
