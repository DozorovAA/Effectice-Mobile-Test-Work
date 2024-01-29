package ru.test.EffectiveMobileTestWork.controller.service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.test.EffectiveMobileTestWork.controller.model.AuthenticationRequest;
import ru.test.EffectiveMobileTestWork.controller.model.AuthenticationResponse;
import ru.test.EffectiveMobileTestWork.service.JwtService;
import ru.test.EffectiveMobileTestWork.model.user.User;
import ru.test.EffectiveMobileTestWork.repo.UserRepository;

import java.util.Optional;

@Service
public class AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationService(UserRepository repository, JwtService jwtService, AuthenticationManager authenticationManager) {
    this.userRepository = repository;
    this.passwordEncoder = new BCryptPasswordEncoder();
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }

  public AuthenticationResponse register(User request) {
    Optional<User> optional = userRepository.findByEmail(request.getEmail());
    if (optional.isPresent()){
      throw new RuntimeException("Error register: user with such email exists in Service");
    }
    else {
      request.setPass(passwordEncoder.encode(request.getPassword()));

      userRepository.save(request);
      var jwtToken = jwtService.generateToken(request);

      return new AuthenticationResponse(jwtToken);
    }
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = userRepository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return new AuthenticationResponse(jwtToken);
  }

}
