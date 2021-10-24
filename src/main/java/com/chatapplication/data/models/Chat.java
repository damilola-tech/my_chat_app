package com.chatapplication.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @OneToMany()
    @ToString.Exclude
    @Column(nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Message> messages;

    @ManyToMany(mappedBy = "chats")
    private final List<User> users = new ArrayList<>(2);

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String title;

    // The @Data annotation already sufficed for the getters below.
    // The code below is just to show how getter is written here.
    public List<User> getUsers() {
        return users;
    }

    public List<Message> getMessages() {
        if(messages == null) {
            messages = new ArrayList<>();
        }

        Collections.sort(messages);

        return messages;
    }
}
