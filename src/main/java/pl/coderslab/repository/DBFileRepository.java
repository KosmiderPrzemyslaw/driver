package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.DbFile;

import java.util.Optional;

public interface DBFileRepository extends JpaRepository<DbFile, Integer> {

//    Optional<DbFile> findById(Integer fileId);
}
