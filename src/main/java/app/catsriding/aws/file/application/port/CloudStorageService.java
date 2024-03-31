package app.catsriding.aws.file.application.port;

import app.catsriding.aws.file.domain.model.FileMetadata;
import app.catsriding.aws.file.domain.model.FileCreate;

public interface CloudStorageService {

    FileMetadata upload(FileCreate fileCreate);

}
