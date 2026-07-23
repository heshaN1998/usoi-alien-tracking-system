package com.soft_universe.tranneer.ai.memory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChatMemoryRepository extends JpaRepository<ChatMemoryEntity,Long> {
    List<ChatMemoryEntity> findByConversationIdOrderByCreatedAtAsc(String conversationId);
}
