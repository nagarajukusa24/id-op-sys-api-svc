package com.idfcfirstbank.idfconpremautomationbackendservice.controller;

import com.idfcfirstbank.idfconpremautomationbackendservice.model.Node;
import com.idfcfirstbank.idfconpremautomationbackendservice.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/dummy")
    public Map<String, Object> getGraphData() {

        List<Map<String, Object>> nodes = List.of(
                Map.of("id", 1, "name", "Node 1"),
                Map.of("id", 2, "name", "Node 2"),
                Map.of("id", 3, "name", "Node 3"),
                Map.of("id", 4, "name", "Node 4")
        );

        List<Map<String, Object>> links = List.of(
                Map.of("source", 1, "target", 2),
                Map.of("source", 2, "target", 3),
                Map.of("source", 2, "target", 4)
        );

        return Map.of("nodes", nodes, "links", links)   ;
    }
}
