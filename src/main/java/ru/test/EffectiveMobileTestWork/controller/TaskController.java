package ru.test.EffectiveMobileTestWork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.test.EffectiveMobileTestWork.controller.mappers.TaskMapper;
import ru.test.EffectiveMobileTestWork.model.task.Task;
import ru.test.EffectiveMobileTestWork.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("api")
public class TaskController {
    private final TaskService taskService;
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("getAll")
    public List<Task> getAllTask() {
        log.info("get All Tasks");
        return taskService.getAllTask();
    }
    @PostMapping("get")
    public Task getTask(@RequestBody Task task) {
        log.info("get All Tasks");
        return taskService.getTask(String.valueOf(task.getTitle()));
    }
    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        log.info("create Tasks");
        return taskService.saveTask(task);
    }
    @PostMapping("/update")
    public Task updateTask(@RequestBody Task task) {
        log.info("update Tasks");
        return taskService.updateTask(TaskMapper.toUpdate(task));
    }
}
