package app.catsriding.aws.file.infra.repository;

import app.catsriding.aws.file.infra.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileJpaRepository extends JpaRepository<FileEntity, Long> {

}
