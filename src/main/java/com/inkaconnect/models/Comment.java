package com.inkaconnect.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String publicationId;
    private String text;
    private String authorFirstName;
    private String authorLastName;
    private LocalDateTime timestamp = LocalDateTime.now();
    private String avatarBase64;
}
