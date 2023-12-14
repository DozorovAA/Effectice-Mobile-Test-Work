package ru.test.EffectiveMobileTestWork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.test.EffectiveMobileTestWork.model.Task;
import ru.test.EffectiveMobileTestWork.service.TaskService;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getAllTask() {
        log.info("get All Tasks");
        return taskService.getAllTask();
    }
    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        System.out.println(task);
        return taskService.saveTask(task);
    }
}
