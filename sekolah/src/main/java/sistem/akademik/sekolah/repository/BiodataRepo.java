package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistem.akademik.sekolah.model.Biodata;

@Repository
public interface BiodataRepo extends JpaRepository<Biodata, Long> {
    
}
