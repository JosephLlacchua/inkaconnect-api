package com.inkaconnect.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "publications")
public class Publication {
    @Id
    private String id;
    private User author;
    private String content;
    private String imageBase64;
    private String authorAvatar;
    private double price;
    private int quantity;
    private String productName;
    private String category;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<String> commentIds = new ArrayList<>();
}