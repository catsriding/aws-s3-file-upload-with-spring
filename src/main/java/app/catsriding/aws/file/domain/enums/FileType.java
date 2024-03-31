package app.catsriding.aws.file.domain.enums;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public enum FileType {

    USER_AVATAR("avatar", "user/avatar/{date}/", "^(jpg|png|svg|gif)$", 10 * 1024 * 1024);

    private final String code;
    private final String directory;
    private final String extensions;
    private final long filesize;

    /**
     * <h2>⚡ FIND BY</h2>
     *
     * @param
     * @throws
     * @apiNote
     * @author Jynn ❖
     * @since Tuesday, 19 March 2024, 01:57PM KST
     */
    public static FileType enumerate(String type) {
        return Arrays.stream(FileType.values())
                .filter(value -> value.code.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid file type"));
    }
}
