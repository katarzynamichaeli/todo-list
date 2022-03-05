package io.github.michaek.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "project_steps")
public class ProjectStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message="Project step's description must not be empty")
    private String description;
    private int daysToDeadline;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public ProjectStep() {
    }

    public int getId() { return this.id; }

    void setId(int id) { this.id = id; }

    public String getDescription() { return this.description; }

    void setDescription(String description) { this.description = description; }

    Project getProject() { return project; }

    void setProject(Project project) { this.project = project; }

    public int getDaysToDeadline() { return daysToDeadline; }

    void setDaysToDeadline(int daysToDeadline) { this.daysToDeadline = daysToDeadline; }

}
