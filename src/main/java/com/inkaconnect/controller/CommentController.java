package com.inkaconnect.controller;

import com.inkaconnect.models.Comment;
import com.inkaconnect.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Endpoint para crear un comentario
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    // Endpoint para obtener comentarios de una publicación
    @GetMapping("/publication/{publicationId}")
    public List<Comment> getCommentsByPublicationId(@PathVariable String publicationId) {
        return commentService.getCommentsByPublicationId(publicationId);
    }
}