package ru.test.EffectiveMobileTestWork.service;

import org.springframework.stereotype.Service;
import ru.test.EffectiveMobileTestWork.model.Task;
import ru.test.EffectiveMobileTestWork.repo.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
