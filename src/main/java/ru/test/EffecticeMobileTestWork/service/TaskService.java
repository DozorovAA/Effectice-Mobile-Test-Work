package ru.test.EffecticeMobileTestWork.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.test.EffecticeMobileTestWork.model.Task;
import ru.test.EffecticeMobileTestWork.repo.TaskRepository;

import java.util.ArrayList;
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
