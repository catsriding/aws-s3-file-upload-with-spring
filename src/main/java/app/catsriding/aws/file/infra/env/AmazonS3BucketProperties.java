package app.catsriding.aws.file.infra.env;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = AmazonS3BucketProperties.PREFIX)
public class AmazonS3BucketProperties {

    public static final String PREFIX = "spring.cloud.aws.s3";

    private String bucket;

}
