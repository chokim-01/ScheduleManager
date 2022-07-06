package com.web.backend.user;



import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfilePictureService {
    private final Environment environment;


    public String fileUploadAndReturnFileName(MultipartFile file){


        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        String newFileName = UUID.randomUUID()+"."+extension;


        try (

                FileOutputStream fos = new FileOutputStream(environment.getProperty("upload.filepath") + newFileName);
                InputStream is = file.getInputStream()) {


            int readCount = 0;
            byte[] buffer = new byte[1024];

            while ((readCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, readCount);

            }
        } catch (Exception ex) {
            throw new RuntimeException("file Save Error");
        }



        return newFileName;
    }

    public void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
    }
}
