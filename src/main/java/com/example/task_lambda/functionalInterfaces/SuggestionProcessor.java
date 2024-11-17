package com.example.task_lambda.functionalInterfaces;

import com.example.task_lambda.enums.SuggestionStatus;

@FunctionalInterface
public interface SuggestionProcessor {

    void suggestion(String text, int rate, SuggestionStatus suggestionStatus);
}
