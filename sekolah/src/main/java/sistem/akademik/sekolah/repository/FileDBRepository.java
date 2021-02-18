package sistem.akademik.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistem.akademik.sekolah.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
