package app.catsriding.aws.file.infra.repository;

import app.catsriding.aws.file.application.port.FileRepository;
import app.catsriding.aws.file.domain.model.File;
import app.catsriding.aws.file.infra.entity.FileEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository {

    private final FileJpaRepository fileJpaRepository;

    @Override
    public File save(File file) {
        FileEntity fileEntity = FileEntity.from(file);
        return fileJpaRepository.save(fileEntity).toModel();
    }
}
