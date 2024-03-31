package app.catsriding.aws.file.domain.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class File {

    private final Long id;
    private final String originalFilename;
    private final String storedFilename;
    private final String fileKey;
    private final String fileUrl;
    private final boolean isDeleted;
    private final Long createdBy;
    private final LocalDateTime createdAt;
    private final Long updatedBy;
    private final LocalDateTime updatedAt;

    @Builder
    public File(
            Long id,
            String originalFilename,
            String storedFilename,
            String fileKey,
            String fileUrl,
            boolean isDeleted,
            Long createdBy,
            LocalDateTime createdAt,
            Long updatedBy,
            LocalDateTime updatedAt) {
        this.id = id;
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.fileKey = fileKey;
        this.fileUrl = fileUrl;
        this.isDeleted = isDeleted;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    public static File from(FileMetadata metadata, LocalDateTime now) {
        return File.builder()
                .originalFilename(metadata.getOriginalFilename())
                .storedFilename(metadata.getStoredFilename())
                .fileKey(metadata.getKey())
                .fileUrl(metadata.getUrl())
                .isDeleted(false)
                .createdBy(1L)
                .createdAt(now)
                .updatedBy(1L)
                .updatedAt(now)
                .build();
    }

    public FileDetails toFileDetails() {
        return FileDetails.builder()
                .fileId(id)
                .originalFilename(originalFilename)
                .storedFilename(storedFilename)
                .fileKey(fileKey)
                .fileUrl(fileUrl)
                .build();
    }
}
