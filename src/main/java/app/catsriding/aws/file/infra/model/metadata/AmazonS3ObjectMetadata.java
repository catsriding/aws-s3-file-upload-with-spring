package app.catsriding.aws.file.infra.model.metadata;

import app.catsriding.aws.file.domain.model.FileMetadata;
import app.catsriding.aws.file.infra.model.request.AmazonS3PutRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AmazonS3ObjectMetadata {

    private final String originalFilename;
    private final String storedFilename;
    private final String key;
    private final String url;
    private final long size;

    @Builder
    public AmazonS3ObjectMetadata(String originalFilename, String storedFilename, String key, String url, long size) {
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.key = key;
        this.url = url;
        this.size = size;
    }

    /**
     * <h2>🏗️ Constructors</h2>
     *
     * @author Jynn ❖
     * @since Thursday, 21 March 2024, 11:02PM KST
     */
    public static AmazonS3ObjectMetadata from(AmazonS3PutRequest request, String objectUrl) {
        return AmazonS3ObjectMetadata.builder()
                .originalFilename(request.getOriginalFilename())
                .storedFilename(request.getStoredFilename())
                .key(request.getKey())
                .url(objectUrl)
                .size(request.getSize())
                .build();
    }

    public FileMetadata toModel() {
        return FileMetadata.builder()
                .originalFilename(originalFilename)
                .storedFilename(storedFilename)
                .key(key)
                .url(url)
                .size(size)
                .build();
    }
}
