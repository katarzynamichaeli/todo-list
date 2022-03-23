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

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TaskGroup> getGroups() { return groups; }

    public void setGroups(Set<TaskGroup> groups) { this.groups = groups; }

    public Set<ProjectStep> getSteps() { return steps; }

    public void setSteps(final Set<ProjectStep> steps) { this.steps = steps; }
}
