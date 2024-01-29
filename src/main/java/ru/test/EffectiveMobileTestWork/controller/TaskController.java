package ru.test.EffectiveMobileTestWork.controller;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.test.EffectiveMobileTestWork.controller.mappers.TaskMapper;
import ru.test.EffectiveMobileTestWork.model.task.Task;
import ru.test.EffectiveMobileTestWork.model.user.User;
import ru.test.EffectiveMobileTestWork.repo.UserRepository;
import ru.test.EffectiveMobileTestWork.service.JwtService;
import ru.test.EffectiveMobileTestWork.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
    private final TaskService taskService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskService taskService, JwtService jwtService, UserRepository userRepository) {
        this.taskService = taskService;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTask() {
        try {
            log.info("Trying get All Tasks");

            String userEmail = jwtService.extractEmail();
            User user = userRepository.findByEmail(userEmail)
                    .orElseThrow(() -> new EntityNotFoundException("User not found for email: " + userEmail));

            List<Task> tasks = taskService.getAllTask();

            log.info("get All Tasks successful");
            return ResponseEntity.ok(tasks);
        } catch (EntityNotFoundException e) {
            log.error("Error get All Tasks: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error creating task: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error get All Tasks", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating task: " + e.getMessage());
        }
    }
    @GetMapping("/getAllExecutor")
    public ResponseEntity<?> getAllExecutorTask() {
        try {
            log.info("Trying get All Executor Tasks");

            String userEmail = jwtService.extractEmail();
            User user = userRepository.findByEmail(userEmail)
                    .orElseThrow(() -> new EntityNotFoundException("User not found for email: " + userEmail));

            List<Task> tasks = taskService.getAllExecutorTask(String.valueOf(user.getId()));

            log.info("get All Executor Tasks successful");
            return ResponseEntity.ok(tasks);
        } catch (EntityNotFoundException e) {
            log.error("Error get All Executor Tasks: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error creating task: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error get All Executor Tasks", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating task: " + e.getMessage());
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        try {
            log.info("Trying to create Task");

            String userEmail = jwtService.extractEmail();
            User user = userRepository.findByEmail(userEmail)
                    .orElseThrow(() -> new EntityNotFoundException("User not found for email: " + userEmail));

            task.setAuthor(user);
            Task savedTask = taskService.saveTask(task);

            log.info("Task creation successful");
            return ResponseEntity.ok(savedTask);
        } catch (EntityNotFoundException e) {
            log.error("Error creating task: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error creating task: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error creating task", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating task: " + e.getMessage());
        }
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        try {
            log.info("Trying to update Task");

            String userEmail = jwtService.extractEmail();
            User user = userRepository.findByEmail(userEmail)
                    .orElseThrow(() -> new EntityNotFoundException("User not found for email: " + userEmail));

            task.setAuthor(user);
            Task savedTask = taskService.updateTask(TaskMapper.toUpdate(task));

            log.info("Task update successful");
            return ResponseEntity.ok(savedTask);
        } catch (EntityNotFoundException e) {
            log.error("Error update task: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error creating task: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error update task", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating task: " + e.getMessage());
        }
    }
}
