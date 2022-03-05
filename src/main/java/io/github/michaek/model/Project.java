package io.github.michaek.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message="Project's description must not be empty")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectStep> steps;
    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> groups;

    public Project() {
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

    Set<TaskGroup> getGroups() { return groups; }

    void setGroups(Set<TaskGroup> groups) { this.groups = groups; }

    Set<ProjectStep> getSteps() { return steps; }

    void setSteps(final Set<ProjectStep> steps) { this.steps = steps; }
}
