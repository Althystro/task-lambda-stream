package com.example.task_lambda.bo;

import com.example.task_lambda.enums.SuggestionStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateSuggestionRequest {

    private int rate;
    private String suggestionText;
    private SuggestionStatus suggestionStatus;

    public CreateSuggestionRequest() {
    }

    public SuggestionStatus getSuggestionStatus() {
        return suggestionStatus;
    }

    public void setSuggestionStatus(SuggestionStatus suggestionStatus) {
        this.suggestionStatus = suggestionStatus;
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


}
