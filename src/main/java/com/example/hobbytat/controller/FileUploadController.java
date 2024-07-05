package com.example.hobbytat.controller;

import com.amazonaws.Response;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.hobbytat.controller.dto.response.PostPhotosResponseDto;
import com.example.hobbytat.controller.dto.response.UrlDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
public class FileUploadController {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @PostMapping
    public PostPhotosResponseDto uploadFile(@RequestParam("imgFile") List<MultipartFile> files) {
        List<UrlDto>urlDtos=new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            try {
                String uuid = UUID.randomUUID().toString();
                String fileUrl = "https://" + bucket + ".s3." + region + ".amazonaws.com/" + uuid;
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType(file.getContentType());
                metadata.setContentLength(file.getSize());
                amazonS3Client.putObject(bucket, uuid, file.getInputStream(), metadata);
                urlDtos.add(UrlDto.builder()
                        .url(fileUrl).
                        build()
                );

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("s3 업로드 중 문제가 발생하였습니다");
            }
        }
        return PostPhotosResponseDto.builder()
                .status(200)
                .isSuccess(true)
                .urls(urlDtos)
                .build();
    }
}
