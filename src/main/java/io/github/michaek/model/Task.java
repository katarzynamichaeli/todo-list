package io.github.michaek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message="Task's description must not be empty")
    private String description;
    private boolean done;

    Task(){

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return this.done;
    }

    void setDone(boolean done) {
        this.done = done;
    }

}