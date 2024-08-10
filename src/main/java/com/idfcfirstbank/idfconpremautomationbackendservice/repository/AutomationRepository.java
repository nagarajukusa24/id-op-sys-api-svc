package com.idfcfirstbank.idfconpremautomationbackendservice.repository;

import com.idfcfirstbank.idfconpremautomationbackendservice.model.Node;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutomationRepository extends Neo4jRepository<Node, String> {

    @Query("MATCH (nodes) RETURN nodes")
    List<Node> findAllNodes();

    @Query("MATCH (ip:Node{ip: $ip}) RETURN ip")
    List<Node> fetchNodeByInputIP(String ip);
}
