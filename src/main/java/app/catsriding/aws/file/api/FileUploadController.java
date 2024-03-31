package app.catsriding.aws.file.api;

import app.catsriding.aws.file.api.port.FileService;
import app.catsriding.aws.file.api.request.FileUploadRequest;
import app.catsriding.aws.file.api.response.FileUploadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/files")
public class FileUploadController {

    private final FileService service;

    @PostMapping
    public ResponseEntity<?> fileUploadApi(
            @RequestParam String type,
            @RequestPart MultipartFile file) {
        FileUploadRequest request = FileUploadRequest.bind(type, file);
        FileUploadResponse response = FileUploadResponse.from(service.upload(request.toModel()));
        return ResponseEntity
                .ok(response);
    }

}
