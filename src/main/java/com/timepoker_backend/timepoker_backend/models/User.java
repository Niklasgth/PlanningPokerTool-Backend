package com.timepoker_backend.timepoker_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String userName;
    private String userPassword;
}
