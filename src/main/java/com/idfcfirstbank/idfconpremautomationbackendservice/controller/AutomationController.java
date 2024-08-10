package com.idfcfirstbank.idfconpremautomationbackendservice.controller;

import com.idfcfirstbank.idfconpremautomationbackendservice.model.Node;
import com.idfcfirstbank.idfconpremautomationbackendservice.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = { RequestMethod.GET, RequestMethod.POST }
)
public class AutomationController {

    @Autowired
    private AutomationService automationService;

    @GetMapping("/fetch-nodes")
    public List<Node> fetchSourceAndDestinationNodes() {
        return automationService.fetchAllNodes();
    }

    @GetMapping("/fetch-node")
    public List<Node> fetchNodeWithInputIP(@RequestParam String ip) {
        return automationService.fetchNodeWithInputIP(ip);
    }

    @GetMapping("/fetch-graph")
    public List<Node> getNodesWithRelationships() {
        return automationService.fetchAllNodesWithRelationships();
    }

    @GetMapping("/node-counter")
    public Integer getNodeCountFromDB() {
        return automationService.fetchNodeCount();
    }

    @GetMapping("relation-counter")
    public Integer getRelationCountFromDB() {
        return automationService.fetchRelationCount();
    }
}
