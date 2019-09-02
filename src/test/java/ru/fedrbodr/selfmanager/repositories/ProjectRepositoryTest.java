package ru.fedrbodr.selfmanager.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.fedrbodr.selfmanager.domain.Project;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private ProjectRepository projectRepository;

	@Test
	public void findAll() {
		Project project = new Project();
		testEntityManager.persistAndFlush(project);

		Iterable<Project> all = projectRepository.findAll();
		Project next = all.iterator().next();
		Assert.assertEquals(next, project);
	}
}
