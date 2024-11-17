package com.example.task_lambda.services;


import com.example.task_lambda.entity.GuestSuggestionEntity;
import com.example.task_lambda.enums.SuggestionStatus;
import com.example.task_lambda.functionalInterfaces.SuggestionProcessor;
import com.example.task_lambda.repositories.GuestSuggestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestSuggestionServiceImpl {
    private GuestSuggestionRepository guestSuggestionRepository = null;

    SuggestionProcessor processSuggestion = (suggestionText, rate, status) -> {
        GuestSuggestionEntity guestSuggestionEntity = new GuestSuggestionEntity();
        guestSuggestionEntity.setSuggestionText(suggestionText);
        guestSuggestionEntity.setRate(rate);
        guestSuggestionEntity.setSuggestionStatus(status);
//        userEntity.setStatus(Status.valueOf(request.getStatus()));

        guestSuggestionRepository.save(guestSuggestionEntity);
        System.out.println("Suggestion saved successfully: " + suggestionText + ", " + rate + ", " + status);
    };

    public GuestSuggestionServiceImpl(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    public String processSuggestion(String suggestionText, int rate, SuggestionStatus status) {

        processSuggestion.suggestion(suggestionText, rate, status);
        return "successful";
    }


    public List<GuestSuggestionEntity> allSuggestions() {
        return guestSuggestionRepository.findAll();

    }


    public List<GuestSuggestionEntity> findAllCreatedSuggestions() {
        return allSuggestions().stream()
                .filter(suggestion -> suggestion.getSuggestionStatus() == SuggestionStatus.CREATE)
                .collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> findAllRemovedSuggestions() {
        return allSuggestions().stream()
                .filter(suggestion -> suggestion.getSuggestionStatus() == SuggestionStatus.REMOVE)
                .collect(Collectors.toList());
    }
}
