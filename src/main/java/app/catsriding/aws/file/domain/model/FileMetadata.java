package app.catsriding.aws.file.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileMetadata {

    private final String originalFilename;
    private final String storedFilename;
    private final String key;
    private final String url;
    private final long size;

    @Builder
    public FileMetadata(String originalFilename, String storedFilename, String key, String url, long size) {
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.key = key;
        this.url = url;
        this.size = size;
    }
}
