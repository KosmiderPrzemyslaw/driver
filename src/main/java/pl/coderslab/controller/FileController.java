//package pl.coderslab.controller;
//
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import pl.coderslab.model.DbFile;
//import pl.coderslab.service.DBFileStorageService;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Objects;
//
//@RestController("/file")
//public class FileController {
//
//    private final DBFileStorageService dbFileStorageService;
//
//    public FileController(DBFileStorageService dbFileStorageService) {
//        this.dbFileStorageService = dbFileStorageService;
//    }
//
//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
//        convertFile.createNewFile();
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
//            fileOutputStream.write(file.getBytes());
//            fileOutputStream.close();
//            dbFileStorageService.saveFile(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
//    }
//
//    @PutMapping(value = "/update/{fileId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public void updateFile(@RequestParam("file") MultipartFile file,
//                           @PathVariable Integer fileId) throws IOException {
//        DbFile dbFile = dbFileStorageService.getFile(fileId).get();
//        dbFileStorageService.updateFile(file, dbFile);
//
//    }
//
//    @GetMapping("/download/{fileId}")
//    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
//        DbFile dbFile = dbFileStorageService.getFile(fileId).get();
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" +
//                        dbFile.getFileName() + "\"")
//                .body(new ByteArrayResource(dbFile.getData()));
//    }
//
//    @DeleteMapping("/delete/{fileId}")
//    public void deleteFile(@PathVariable Integer fileId) {
//        dbFileStorageService.deleteFile(fileId);
//    }
//
//}