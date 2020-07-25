package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.model.DbFile;
import pl.coderslab.repository.DBFileRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DBFileStorageService {


    private final DBFileRepository dbFileRepository;


    public DBFileStorageService(DBFileRepository dbFileRepository) {
        this.dbFileRepository = dbFileRepository;
    }

    public void saveFile(MultipartFile multipartFile) {
        String docName = multipartFile.getOriginalFilename();
        try {
            DbFile dbFile = new DbFile();
            dbFile.setFileName(docName);
            dbFile.setFileType(multipartFile.getContentType());
            dbFile.setData(multipartFile.getBytes());
            dbFileRepository.save(dbFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<DbFile> getFile(Integer fileId) {
        return dbFileRepository.findById(fileId);
    }

    public List<DbFile> getFiles() {
        return dbFileRepository.findAll();
    }

    public void deleteFile(Integer fileId) {
        Optional<DbFile> dbFile = dbFileRepository.findById(fileId);
        dbFileRepository.delete(dbFile.get());
    }

    public void updateFile(MultipartFile multipartFile, DbFile dbFile) throws IOException {

        dbFile.setFileName(multipartFile.getOriginalFilename());
        dbFile.setFileType(multipartFile.getContentType());
        dbFile.setData(multipartFile.getBytes());
        dbFileRepository.save(dbFile);
    }
}