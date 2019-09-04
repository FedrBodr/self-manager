package ru.fedrbodr.selfmanager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Project name is required")
	private String projectName;

	@NotBlank(message = "Project identifier is required")
	@Size(min=4, message = "Please use more then 4 characters")
	@Column(updatable = false, unique = true)
	private String projectIdentifier;

	@NotBlank(message = "Project description is required")
	private String description;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date startDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date endDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date created;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updated;

	public Project() {
	}

	public Long getId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Project project = (Project) o;

		return id.equals(project.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
