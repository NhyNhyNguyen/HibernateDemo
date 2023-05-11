package com.example.demo.enver;

import org.hibernate.envers.RevisionListener;

import java.util.Random;

public class ExampleListener implements RevisionListener {

    @Override
    public void newRevision(Object o) {
        ExampleRevEntity exampleRevEntity = (ExampleRevEntity) o;
        exampleRevEntity.setUsername("Nhi" + (new Random().nextInt()));
    }
}
