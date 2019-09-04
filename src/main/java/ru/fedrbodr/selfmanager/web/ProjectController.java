package ru.fedrbodr.selfmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.fedrbodr.selfmanager.domain.Project;
import ru.fedrbodr.selfmanager.services.MapValidationService;
import ru.fedrbodr.selfmanager.services.ProjectService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MapValidationService mapValidationService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
		Optional<ResponseEntity<?>> errorResponseEntityOptional = mapValidationService.mapErroredResultToResponseEntity(result);
		return errorResponseEntityOptional
				.orElseGet(() ->
						new ResponseEntity<Project>(
								projectService.saveOrUpdateProject(project),
								HttpStatus.CREATED)
				);
	}

	@GetMapping("/{projectIdentifier}")
	public ResponseEntity<Project> testProject(@PathVariable String projectIdentifier) {
		Project project = projectService.getByIdentifier(projectIdentifier);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
}