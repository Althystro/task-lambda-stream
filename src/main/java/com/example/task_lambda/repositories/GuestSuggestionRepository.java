package com.example.task_lambda.repositories;

import com.example.task_lambda.entity.GuestSuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity, Long> {
}
