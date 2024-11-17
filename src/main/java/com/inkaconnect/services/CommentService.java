package com.inkaconnect.services;

import com.inkaconnect.models.Comment;
import com.inkaconnect.repositories.CommentRepository;
import com.inkaconnect.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PublicationRepository publicationRepository; // Para actualizar la publicación

    public Comment createComment(Comment comment) {
        // Guardamos el comentario en la colección de comentarios
        Comment savedComment = commentRepository.save(comment);

        // Obtenemos la publicación relacionada y actualizamos su lista de comentarios
        publicationRepository.findById(comment.getPublicationId()).ifPresent(publication -> {
            publication.getCommentIds().add(savedComment.getId()); // Agrega el ID del comentario
            publicationRepository.save(publication); // Guarda la publicación actualizada
        });

        return savedComment;
    }

    public List<Comment> getCommentsByPublicationId(String publicationId) {
        return commentRepository.findByPublicationId(publicationId);
    }
}