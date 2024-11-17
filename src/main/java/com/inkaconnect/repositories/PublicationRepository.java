package com.inkaconnect.repositories;

import com.inkaconnect.models.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PublicationRepository extends MongoRepository<Publication,String> {
    List<Publication> findByAuthorId(String authorId);
}
