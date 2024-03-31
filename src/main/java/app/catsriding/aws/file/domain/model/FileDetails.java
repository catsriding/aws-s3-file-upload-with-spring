package app.catsriding.aws.file.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileDetails {

    private final Long fileId;
    private final String originalFilename;
    private final String storedFilename;
    private final String fileKey;
    private final String fileUrl;

    @Builder
    public FileDetails(Long fileId, String originalFilename, String storedFilename, String fileKey, String fileUrl) {
        this.fileId = fileId;
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.fileKey = fileKey;
        this.fileUrl = fileUrl;
    }
}
