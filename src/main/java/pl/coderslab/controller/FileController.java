package pl.coderslab.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.model.DbFile;
import pl.coderslab.service.DBFileStorageService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController("/file")
public class FileController {

    private final DBFileStorageService dbFileStorageService;

    public FileController(DBFileStorageService dbFileStorageService) {
        this.dbFileStorageService = dbFileStorageService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File(file.getOriginalFilename());
        convertFile.createNewFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            dbFileStorageService.saveFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("File is uploaded succesfully", HttpStatus.OK);
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
        DbFile dbFile = dbFileStorageService.getFile(fileId).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" +
                        dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
}
