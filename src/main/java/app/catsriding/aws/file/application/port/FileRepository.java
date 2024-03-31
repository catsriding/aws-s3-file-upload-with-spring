package app.catsriding.aws.file.application.port;

import app.catsriding.aws.file.domain.model.File;

public interface FileRepository {

    File save(File file);

}
