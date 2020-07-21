package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.DBFile;

import java.util.Optional;

public interface DBFileRepository extends JpaRepository<DBFile, String> {
    <T> Optional<T> findById(String fileId);
}
