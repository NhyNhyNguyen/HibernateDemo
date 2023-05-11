package com.example.demo.entities.oneToMany;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "answer")
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

    public Answer() {
    }

    public Answer(int id, String answerName, String postedBy) {
        this.id = id;
        this.answerName = answerName;
        this.postedBy = postedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
}
