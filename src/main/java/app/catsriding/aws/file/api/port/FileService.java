package app.catsriding.aws.file.api.port;

import app.catsriding.aws.file.domain.model.FileDetails;
import app.catsriding.aws.file.domain.model.FileCreate;

public interface FileService {

    FileDetails upload(FileCreate fileCreate);

}
