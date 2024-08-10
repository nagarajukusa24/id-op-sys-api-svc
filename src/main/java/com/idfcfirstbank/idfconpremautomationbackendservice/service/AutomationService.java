package com.idfcfirstbank.idfconpremautomationbackendservice.service;

import com.idfcfirstbank.idfconpremautomationbackendservice.model.Node;
import com.idfcfirstbank.idfconpremautomationbackendservice.repository.AutomationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomationService {

    @Autowired AutomationRepository automationRepository;

    public List<Node> fetchAllNodes() {
        return automationRepository.findAllNodes();
    }

    public List<Node> fetchNodeWithInputIP(String ip) {
        return automationRepository.fetchNodeByInputIP(ip);
    }

    public List<Node> fetchAllNodesWithRelationships() {
        return automationRepository.findAllNodesWithRelationships();
    }

    public Integer fetchNodeCount() {
        return automationRepository.getNodeCount();
    }

    public Integer fetchRelationCount() {
        return automationRepository.getRelationCount();
    }
}
