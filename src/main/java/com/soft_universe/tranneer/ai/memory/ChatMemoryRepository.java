package com.soft_universe.tranneer.ai.memory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMemoryRepository extends JpaRepository<ChatMemoryEntity,Long> {
    List<ChatMemoryEntity> findByConversationInOrderByCreatedAtAsc(String conversationId);
}
