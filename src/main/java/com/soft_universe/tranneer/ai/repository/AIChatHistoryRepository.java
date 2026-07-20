package com.soft_universe.tranneer.ai.repository;

import com.soft_universe.tranneer.ai.entity.AIChatHistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AIChatHistoryRepository extends JpaRepository<AIChatHistory,Long> {
List<AIChatHistory> findTop20ByUserNameOrderByCreatedAtDesc(String userName);

}
