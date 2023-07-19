package com.example.book.hibernate.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    private Message nextMessage;

    public Message(String text) {
        this.text = text;
    }
}
