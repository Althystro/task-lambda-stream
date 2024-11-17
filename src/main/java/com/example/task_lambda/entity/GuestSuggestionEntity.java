package com.example.task_lambda.entity;

import com.example.task_lambda.enums.SuggestionStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "guest_suggestions") // Optional: Specify the table name explicitly
public class GuestSuggestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rate;

    private String suggestionText;

    @Enumerated(EnumType.STRING) // Store enum values as strings in the database
    private SuggestionStatus suggestionStatus;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public SuggestionStatus getSuggestionStatus() {
        return suggestionStatus;
    }

    public void setSuggestionStatus(SuggestionStatus suggestionStatus) {
        this.suggestionStatus = suggestionStatus;
    }
}
