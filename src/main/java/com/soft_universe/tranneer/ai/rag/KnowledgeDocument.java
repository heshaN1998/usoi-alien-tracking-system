package com.soft_universe.tranneer.ai.rag;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KnowledgeDocument {
private String content;
private String type;
private String referenceId;

}
