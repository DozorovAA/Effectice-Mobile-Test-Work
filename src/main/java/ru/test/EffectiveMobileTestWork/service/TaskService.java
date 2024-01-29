package ru.test.EffectiveMobileTestWork.service;

import org.springframework.stereotype.Service;
import ru.test.EffectiveMobileTestWork.model.task.Task;
import ru.test.EffectiveMobileTestWork.model.task.TaskPatch;
import ru.test.EffectiveMobileTestWork.repo.TaskRepository;

import java.util.List;
import java.util.Optional;

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

    public Task updateTask(TaskPatch task) {
        Optional<Task> optional = taskRepository.findById(task.getId());
        if(optional.isPresent()){
            Task oldTask = optional.get();
            oldTask.apply(task);
            return taskRepository.save(oldTask);
        } else {
            throw new RuntimeException();
        }
    }

    public Task getTask(String title) {
        Optional<Task> task =  taskRepository.findByTitle(title);
        if(task.isPresent())
            return task.get();
        else
            throw new RuntimeException();
    }

    public List<Task> getAllExecutorTask(String id) {
        return taskRepository.findByExecutorId(id);
    }
}
