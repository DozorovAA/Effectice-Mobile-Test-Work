package ru.test.EffecticeMobileTestWork.controller;

import org.springframework.web.bind.annotation.*;
import ru.test.EffecticeMobileTestWork.model.Task;
import ru.test.EffecticeMobileTestWork.service.TaskService;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }
    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        System.out.println(task);
        return taskService.saveTask(task);
    }
}
