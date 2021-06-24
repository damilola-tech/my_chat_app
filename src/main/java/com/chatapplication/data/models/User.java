package com.chatapplication.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(nullable = false, unique = true, length = 15)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

    private String imageUrl;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @NotEmpty
    @Column(length = 500)
    private List<Chat> chats;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }
}
