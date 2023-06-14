package com.example.demo.entities.oneToMany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "answer")
@Getter
@Setter
@Audited
public class Answer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ANSWER_SEQ"
    )
    @SequenceGenerator(
            name = "ANSWER_SEQ",
            sequenceName = "ANSWER_SEQ",
            allocationSize = 1,
            initialValue = 1000
    )
    private int id;
    private String answerName;
    private String postedBy;

    private Boolean test;

    public Answer() {
    }

    public Answer(int id, String answerName, String postedBy) {
        this.id = id;
        this.answerName = answerName;
        this.postedBy = postedBy;
    }

}
