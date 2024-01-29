package ru.test.EffectiveMobileTestWork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.EffectiveMobileTestWork.controller.model.AuthenticationRequest;
import ru.test.EffectiveMobileTestWork.controller.model.AuthenticationResponse;
import ru.test.EffectiveMobileTestWork.controller.service.AuthenticationService;
import ru.test.EffectiveMobileTestWork.model.user.User;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

  private final AuthenticationService authenticationService;
  private static final Logger log = LoggerFactory.getLogger(TaskController.class);

  public AuthenticationController(AuthenticationService service) {
    this.authenticationService = service;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody User request) {
    try {
      return ResponseEntity.ok(authenticationService.register(request));
    } catch (Exception e) {
      log.error("Error update task", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating task: " + e.getMessage());
    }  }
  @PostMapping("/authenticate")
  public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
    try {
      return ResponseEntity.ok(authenticationService.authenticate(request));
    } catch (Exception e) {
      log.error("Error update task", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating task: " + e.getMessage());
    }
  }
}
