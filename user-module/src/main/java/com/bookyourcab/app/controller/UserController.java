package com.bookyourcab.app.controller;

import com.bookyourcab.app.dto.UserRequestDTO;
import com.bookyourcab.app.dto.UserResponseDTO;
import com.bookyourcab.app.service.UserService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    private final ObservationRegistry observationRegistry;

    public UserController(UserService userService, ObservationRegistry observationRegistry) {
        this.userService = userService;
        this.observationRegistry = observationRegistry;
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable(name = "userId")String userId){
       return Observation.createNotStarted("GET-USER-BY-ID",observationRegistry)
               .observe(() -> new ResponseEntity<>(userService.getUserById(Long.valueOf(userId)), HttpStatus.OK));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return Observation.createNotStarted("GET-ALL-USERS",observationRegistry)
                .observe(() -> new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK));
    }

    @GetMapping("/find")
    public ResponseEntity<UserResponseDTO> getUserEmailOrMobile(@RequestParam(name = "userEmail")String userEmail){
        return Observation.createNotStarted("GET-USER-BY-EMAIL-OR-MOBILE",observationRegistry)
                .observe(() -> new ResponseEntity<>(userService.getUserByEmailOrMobile(userEmail), HttpStatus.OK));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerNewUser(@RequestBody UserRequestDTO userRequestDTO){
        return Observation.createNotStarted("SAVE-NEW-USER",observationRegistry)
                .observe(() -> new ResponseEntity<>(userService.registerNewUser(userRequestDTO),HttpStatus.OK));
    }
}
