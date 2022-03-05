package io.github.michaek.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "task_groups")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message="Task group's description must not be empty")
    private String description;
    private boolean done;
    @Embedded
    private Audit audit = new Audit();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> tasks;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    TaskGroup(){
    }

    public int getId() { return this.id; }

    void setId(int id) {
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

    public void setDone(boolean done) {
        this.done = done;
    }

    public Set<Task> getTasks() { return tasks; }

    void setTasks(final Set<Task> tasks) { this.tasks = tasks; }

    public Project getProject() { return project; }

    public void setProject(Project project) { this.project = project; }
}