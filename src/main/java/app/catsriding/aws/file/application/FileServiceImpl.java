package app.catsriding.aws.file.application;

import app.catsriding.aws.file.api.port.FileService;
import app.catsriding.aws.file.application.components.FileCreator;
import app.catsriding.aws.file.application.port.CloudStorageService;
import app.catsriding.aws.file.domain.model.FileDetails;
import app.catsriding.aws.file.domain.model.FileMetadata;
import app.catsriding.aws.file.domain.model.FileCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileCreator fileCreator;
    private final CloudStorageService cloudStorageService;

    @Override
    public FileDetails upload(FileCreate fileCreate) {
        FileMetadata metadata = cloudStorageService.upload(fileCreate);
        FileDetails fileDetails = fileCreator.persist(metadata);

        log.info("upload: Successfully created file - fileId={} filename={}",
                fileDetails.getFileId(),
                fileDetails.getOriginalFilename());

        return fileDetails;
    }

}
