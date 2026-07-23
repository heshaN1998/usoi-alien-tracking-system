package com.soft_universe.tranneer.ai.memory;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersistentMemoryService {
    private final ChatMemoryRepository repository;

    public PersistentMemoryService(ChatMemoryRepository repository){
        this.repository=repository;
    }

    public void save(String conversationId,String role,String content){
        ChatMemoryEntity memory=new ChatMemoryEntity();
        memory.setConversationId(conversationId);
        memory.setRole(role);
        memory.setContent(content);
        repository.save(memory);
    }

    public String getHistory(String conversationId){
        List<ChatMemoryEntity> memories=repository.findByConversationIdOrderByCreatedAtAsc(conversationId);

        StringBuilder history=new StringBuilder();
        memories.forEach(m->history.append(m.getRole()).append(":").append(m.getContent()).append("\n"));
        return history.toString();
    }

}
