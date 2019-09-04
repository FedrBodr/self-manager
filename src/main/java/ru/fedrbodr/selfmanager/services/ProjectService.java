package ru.fedrbodr.selfmanager.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.fedrbodr.selfmanager.domain.Project;
import ru.fedrbodr.selfmanager.exceptions.ProjectIdException;
import ru.fedrbodr.selfmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	private final Logger log = LoggerFactory.getLogger(ProjectService.class);
	private final ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (DataIntegrityViolationException e) {
			throw new ProjectIdException("Project identifier '" + project.getProjectIdentifier().toUpperCase()+"' already exist");
		}
	}

	public Project getByIdentifier(String projectIdentifier){
		return projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase())
				.orElseThrow(() -> new ProjectIdException("Project identifier '" + projectIdentifier.toUpperCase()+"' does not exist"));
	}

	public Iterable<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	public void deleteByIdentifier(String projectIdentifier){
		Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase())
				.orElseThrow(() ->
						new ProjectIdException("Cannot delete project with identifier '" + projectIdentifier.toUpperCase() + "', this project does not exist"));
		projectRepository.delete(project);
	}
}
