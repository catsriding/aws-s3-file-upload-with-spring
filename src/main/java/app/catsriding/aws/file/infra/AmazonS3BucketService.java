package app.catsriding.aws.file.infra;

import app.catsriding.aws.common.service.ClockHolder;
import app.catsriding.aws.file.application.port.CloudStorageService;
import app.catsriding.aws.file.domain.model.FileCreate;
import app.catsriding.aws.file.domain.model.FileMetadata;
import app.catsriding.aws.file.infra.env.AmazonS3BucketProperties;
import app.catsriding.aws.file.infra.model.metadata.AmazonS3ObjectMetadata;
import app.catsriding.aws.file.infra.model.request.AmazonS3PutRequest;
import io.awspring.cloud.s3.S3Resource;
import io.awspring.cloud.s3.S3Template;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AmazonS3BucketService implements CloudStorageService {

    private final AmazonS3BucketProperties s3BucketProperties;
    private final ClockHolder clockHolder;
    private final S3Template s3Template;

    @Override
    public FileMetadata upload(FileCreate fileCreate) {
        AmazonS3PutRequest amazonS3PutRequest = AmazonS3PutRequest.from(fileCreate, clockHolder.stampCurrentDate());

        try (InputStream inputStream = amazonS3PutRequest.getFile().getInputStream()) {
            S3Resource s3Resource = s3Template.upload(
                    s3BucketProperties.getBucket(),
                    amazonS3PutRequest.getKey(),
                    inputStream);

            String objectUrl = s3Resource.getURL().toExternalForm();
            return AmazonS3ObjectMetadata.from(amazonS3PutRequest, objectUrl).toModel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
