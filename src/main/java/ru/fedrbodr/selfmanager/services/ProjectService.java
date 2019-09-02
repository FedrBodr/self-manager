package ru.fedrbodr.selfmanager.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.fedrbodr.selfmanager.domain.Project;
import ru.fedrbodr.selfmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	private final Logger log = LoggerFactory.getLogger(ProjectService.class);
	private final ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Project saveOrUpdateProject(Project project) {
		return projectRepository.save(project);
	}
}
