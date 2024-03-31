package app.catsriding.aws.file.infra.entity;

import app.catsriding.aws.file.domain.model.File;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "FILES")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "bigint unsigned")
    private Long id;

    @Column(name = "original_filename", nullable = false, length = 100)
    private String originalFilename;

    @Column(name = "stored_filename", nullable = false, length = 100)
    private String storedFilename;

    @Column(name = "file_key", nullable = false, length = 1_000)
    private String fileKey;

    @Column(name = "file_url", nullable = false, length = 1_000)
    private String fileUrl;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", nullable = false)
    private Long updatedBy;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    /**
     * <h2>🏗️ Constructors</h2>
     *
     * @author Jynn ❖
     * @since Thursday, 21 March 2024, 11:05PM KST
     */
    public static FileEntity from(File file) {
        FileEntity entity = new FileEntity();
        entity.id = file.getId();
        entity.originalFilename = file.getOriginalFilename();
        entity.storedFilename = file.getStoredFilename();
        entity.fileKey = file.getFileKey();
        entity.fileUrl = file.getFileUrl();
        entity.isDeleted = file.isDeleted();
        entity.createdBy = file.getCreatedBy();
        entity.createdAt = file.getCreatedAt();
        entity.updatedBy = file.getUpdatedBy();
        entity.updatedAt = file.getUpdatedAt();
        return entity;
    }

    public File toModel() {
        return File.builder()
                .id(id)
                .originalFilename(originalFilename)
                .storedFilename(storedFilename)
                .fileKey(fileKey)
                .fileUrl(fileUrl)
                .isDeleted(isDeleted)
                .createdBy(createdBy)
                .createdAt(createdAt)
                .updatedBy(updatedBy)
                .updatedAt(updatedAt)
                .build();
    }

}
