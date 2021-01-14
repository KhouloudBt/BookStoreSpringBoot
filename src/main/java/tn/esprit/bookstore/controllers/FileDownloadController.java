package tn.esprit.bookstore.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class FileDownloadController {

    @Autowired
    private tn.esprit.bookstore.services.ResourceService resourceService;

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity < Resource > downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        tn.esprit.bookstore.entities.Resource resource = resourceService.getFile(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(resource.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFileName() + "\"")
                .body(new ByteArrayResource(resource.getData()));
    }
}