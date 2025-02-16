package com.inkaconnect.repositories;

import com.inkaconnect.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment,String> {
    List<Comment> findByPublicationId(String publicationId); // Encuentra comentarios por `publicationId`
}
