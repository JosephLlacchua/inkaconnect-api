package com.inkaconnect.services;

import com.inkaconnect.exceptions.AuthorNotFoundException;
import com.inkaconnect.models.Comment;
import com.inkaconnect.models.Publication;
import com.inkaconnect.models.User;
import com.inkaconnect.repositories.CommentRepository;
import com.inkaconnect.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository commentRepository;

    public Publication createPublication(Publication publication) {
        User author = userService.findById(publication.getAuthor().getId()).orElseThrow(() -> new AuthorNotFoundException("Author ID does not exist"));
        publication.setAuthor(author);
        return publicationRepository.save(publication);
    }

    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    public List<Comment> getCommentsForPublication(String publicationId) {
        Optional<Publication> optionalPublication = publicationRepository.findById(publicationId);

        if (optionalPublication.isPresent()) {
            List<String> commentIds = optionalPublication.get().getCommentIds();
            return commentRepository.findAllById(commentIds); // Fetch comments by their IDs
        } else {
            throw new RuntimeException("Publication not found");
        }
    }
}