package com.example.demo.entities.oneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "QUESTION_SEQ"
    )
    @SequenceGenerator(
            name = "QUESTION_SEQ",
            sequenceName = "QUESTION_SEQ",
            allocationSize = 1,
            initialValue = 1000
    )
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "qid")
    @OrderColumn(name = "type")
    private List<Answer> answers;

    private String questionName;

    public Question() {
    }

    public Question(int id, List<Answer> answers) {
        this.id = id;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }
}
