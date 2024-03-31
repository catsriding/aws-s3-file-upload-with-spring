package app.catsriding.aws.file.api.request;

import app.catsriding.aws.file.domain.enums.FileType;
import app.catsriding.aws.file.domain.model.FileCreate;
import java.util.regex.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Getter
@Builder
public class FileUploadRequest {

    private final String type;
    private final MultipartFile file;

    /**
     * <h2>🏗️ Constructors</h2>
     *
     * @author Jynn ❖
     * @since Tuesday, 19 March 2024, 01:58PM KST
     */
    public static FileUploadRequest bind(String type, MultipartFile file) {
        validate(type, file);
        return FileUploadRequest.builder()
                .type(type)
                .file(file)
                .build();
    }

    private static void validate(String type, MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (file.getSize() == 0) {
            throw new IllegalArgumentException();
        }
        if (!StringUtils.hasText(file.getOriginalFilename())) {
            throw new IllegalArgumentException();
        }
        if (!StringUtils.hasText(type)) {
            throw new IllegalArgumentException();
        }
        if (!isAllowedTypes(type)) {
            throw new IllegalArgumentException();
        }
        if (!isAllowedExtensions(file.getOriginalFilename(), type)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isAllowedTypes(String type) {
        String pattern = "^(avatar|thumbnail|content)$";
        return Pattern.matches(pattern, type);
    }

    private static boolean isAllowedExtensions(String filename, String type) {
        int fileExtensionStartIndex = filename.lastIndexOf(".") + 1;
        String extension = filename.substring(fileExtensionStartIndex).toLowerCase();
        String pattern = FileType.enumerate(type).getExtensions();
        return Pattern.matches(pattern, extension);
    }

    public FileCreate toModel() {
        return FileCreate.builder()
                .type(type)
                .file(file)
                .build();
    }
}
