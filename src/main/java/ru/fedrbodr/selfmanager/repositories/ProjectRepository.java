package ru.fedrbodr.selfmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fedrbodr.selfmanager.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository <Project, Long> {

	@Override
	Iterable<Project> findAllById(Iterable<Long> iterable);
}
