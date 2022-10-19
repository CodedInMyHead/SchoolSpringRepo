package com.sap.school.sae.controller;

import com.sap.school.sae.service.TreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChristmasTreeController {

    TreeService treeService;
    ChristmasTreeController(final TreeService treeService) {
        this.treeService = treeService;
    }


    @PostMapping("tree/{height}")
    public ResponseEntity<String> setTreeLength(@PathVariable final int height) {
        if (height < 0 || height > 100) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            treeService.setHeight(height);
            return ResponseEntity.ok(treeService.getTree());
        }

    }

    @GetMapping("tree")
    public ResponseEntity<String> getTree() {
        return ResponseEntity.ok(treeService.getTree());
    }
}
