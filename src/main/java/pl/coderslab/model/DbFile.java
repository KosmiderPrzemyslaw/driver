package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DbFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    public DbFile(String fileName, String contentType, byte[] bytes) {
    }

    public DbFile(String name, String content) {
    }
}
