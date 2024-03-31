package app.catsriding.aws.file.api.response;

import app.catsriding.aws.file.domain.model.FileDetails;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FileUploadResponse {

    private final Long fileId;
    private final String filename;
    private final String filepath;

    @Builder
    public FileUploadResponse(Long fileId, String filename, String filepath) {
        this.fileId = fileId;
        this.filename = filename;
        this.filepath = filepath;
    }

    public static FileUploadResponse from(FileDetails fileDetails) {
        return FileUploadResponse.builder()
                .fileId(fileDetails.getFileId())
                .filename(fileDetails.getOriginalFilename())
                .filepath(fileDetails.getFileUrl())
                .build();
    }
}
