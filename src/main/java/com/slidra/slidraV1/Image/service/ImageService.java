package com.slidra.slidraV1.Image.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String saveFile(MultipartFile file);
}
