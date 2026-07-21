package com.soft_universe.tranneer.ai.rag;


import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommanderKnowledgeService {


    private final KnowledgeRetriever retriever;


    public CommanderKnowledgeService(
            KnowledgeRetriever retriever
    ){

        this.retriever = retriever;

    }



    public String retrieve(String query){


        List<Document> documents =
                retriever.search(query);



        return documents.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n"));

    }

}