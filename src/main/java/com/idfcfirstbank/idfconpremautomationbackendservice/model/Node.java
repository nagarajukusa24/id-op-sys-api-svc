package com.idfcfirstbank.idfconpremautomationbackendservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@org.springframework.data.neo4j.core.schema.Node
public class Node {

    @Id
    private String ip;
    private String name;
}
