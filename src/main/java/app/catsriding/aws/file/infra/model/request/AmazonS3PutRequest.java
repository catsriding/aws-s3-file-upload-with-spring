package app.catsriding.aws.file.infra.model.request;

import static app.catsriding.aws.file.domain.enums.FileType.enumerate;

import app.catsriding.aws.file.domain.model.FileCreate;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class AmazonS3PutRequest {

    private final MultipartFile file;
    private final String originalFilename;
    private final String storedFilename;
    private final String key;
    private final long size;

    @Builder
    public AmazonS3PutRequest(
            MultipartFile file,
            String originalFilename,
            String storedFilename,
            String key,
            long size) {
        this.file = file;
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.key = key;
        this.size = size;
    }

    /**
     * <h2>🏗️ Constructors</h2>
     *
     * @author Jynn ❖
     * @since Wednesday, 20 March 2024, 01:49AM KST
     */
    public static AmazonS3PutRequest from(FileCreate request, String datestamp) {
        MultipartFile file = request.getFile();
        String originalFilename = generateOriginalFilename(file);
        String storedFilename = generateStoredFilename(originalFilename);
        String directory = generateDirectory(request.getType(), datestamp);
        String key = generateObjectKey(directory, storedFilename);

        return AmazonS3PutRequest.builder()
                .file(file)
                .originalFilename(originalFilename)
                .storedFilename(storedFilename)
                .key(key)
                .size(file.getSize())
                .build();
    }

    private static String generateOriginalFilename(MultipartFile file) {
        return file.getOriginalFilename();
    }

    private static String generateStoredFilename(String originalFilename) {
        String extension = extractExtension(originalFilename);
        return UUID.randomUUID() + "." + extension;
    }

    private static String extractExtension(String filename) {
        int fileExtensionStartIndex = filename.lastIndexOf(".") + 1;
        return filename.substring(fileExtensionStartIndex).toLowerCase();
    }

    private static String generateDirectory(String type, String datestamp) {
        String directory = enumerate(type).getDirectory();
        return directory.replace("{date}", datestamp);
    }

    private static String generateObjectKey(String directory, String storedFilename) {
        return directory + storedFilename;
    }
}
