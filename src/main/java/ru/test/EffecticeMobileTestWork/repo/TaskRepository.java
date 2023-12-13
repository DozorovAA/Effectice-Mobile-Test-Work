package ru.test.EffecticeMobileTestWork.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.EffecticeMobileTestWork.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
