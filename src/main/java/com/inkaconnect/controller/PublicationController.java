package com.inkaconnect.controller;

import com.inkaconnect.models.Comment;
import com.inkaconnect.models.Publication;
import com.inkaconnect.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @PostMapping
    public Publication createPublication(@RequestBody Publication publication) {
        return publicationService.createPublication(publication);
    }

    @GetMapping
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @GetMapping("/{publicationId}/comments")
    public List<Comment> getCommentsForPublication(@PathVariable String publicationId) {
        return publicationService.getCommentsForPublication(publicationId);
    }
}