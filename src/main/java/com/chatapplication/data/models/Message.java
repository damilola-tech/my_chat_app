package com.chatapplication.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Comparator;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Comparable<Message> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @NotEmpty
    @Column(name= "messageBody", nullable = false, length = 500)
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @NotNull
    @OneToOne
    private User sender;

    @OneToOne
    private User receiver;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Chat chat;

    @Override
    public int compareTo(Message other) {
        return this.getCreatedAt().compareTo(other.getCreatedAt());
    }
}
