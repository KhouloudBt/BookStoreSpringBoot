package tn.esprit.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.bookstore.dao.ResourceRepository;
import tn.esprit.bookstore.entities.Resource;
import tn.esprit.bookstore.exceptions.FileNotFoundException;
import tn.esprit.bookstore.exceptions.FileStorageException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Resource resource = new Resource(fileName, file.getContentType(), file.getBytes());

            return resourceRepository.save(resource);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource getFile(String fileId) {
        return resourceRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }
}