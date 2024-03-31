package app.catsriding.aws.file.application.components;

import app.catsriding.aws.common.service.ClockHolder;
import app.catsriding.aws.file.application.port.FileRepository;
import app.catsriding.aws.file.domain.model.File;
import app.catsriding.aws.file.domain.model.FileDetails;
import app.catsriding.aws.file.domain.model.FileMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileCreator {

    private final FileRepository fileRepository;
    private final ClockHolder clockHolder;

    @Transactional
    public FileDetails persist(FileMetadata metadata) {
        File file = File.from(metadata, clockHolder.now());
        return fileRepository.save(file).toFileDetails();
    }
}
