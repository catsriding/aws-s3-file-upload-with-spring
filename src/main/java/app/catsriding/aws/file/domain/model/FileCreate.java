package app.catsriding.aws.file.domain.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class FileCreate {

    private final String type;
    private final MultipartFile file;

    @Builder
    public FileCreate(String type, MultipartFile file) {
        this.type = type;
        this.file = file;
    }
}
