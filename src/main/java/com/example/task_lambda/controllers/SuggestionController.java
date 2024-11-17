package com.example.task_lambda.controllers;

import com.example.task_lambda.bo.CreateSuggestionRequest;
import com.example.task_lambda.entity.GuestSuggestionEntity;
import com.example.task_lambda.services.GuestSuggestionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuggestionController {


    private final GuestSuggestionServiceImpl guestSuggestionService;


    public SuggestionController(GuestSuggestionServiceImpl guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }


    @PostMapping("/sendSuggestion")
    public ResponseEntity<String> createUser(@RequestBody CreateSuggestionRequest request) {

        String response = guestSuggestionService.processSuggestion(request.getSuggestionText(), request.getRate(), request.getSuggestionStatus());

        // Check if the response is not null (indicating a successful creation)
        if (response != null) {
            // Return a 201 Created status code along with the created user data
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            // Handle the case where the creation was not successful (e.g., validation failed)
            // You can return a different status code or error message as needed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/getAllSuggestions")
    public List<GuestSuggestionEntity> getAllSuggestions() {
        return guestSuggestionService.allSuggestions();
    }

    @GetMapping("/getCreatedSuggestions")
    public List<GuestSuggestionEntity> getCreatedSuggestions() {
        return guestSuggestionService.findAllCreatedSuggestions();
    }

    @GetMapping("/getRemovedSuggestions")
    public List<GuestSuggestionEntity> getRemovedSuggestions() {
        return guestSuggestionService.findAllRemovedSuggestions();
    }
}
