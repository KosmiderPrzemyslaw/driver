package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.DbFile;

public interface DBFileRepository extends JpaRepository<DbFile, Integer> {

}
